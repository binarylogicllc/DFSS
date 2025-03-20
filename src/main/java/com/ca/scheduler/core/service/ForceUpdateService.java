package com.ca.scheduler.core.service;
import com.ca.scheduler.core.dao.*;
import com.ca.scheduler.core.domain.*;
import com.ca.scheduler.core.domain.values.ForceUpdateSchedulerStatus;
import com.ca.scheduler.core.domain.values.ParamName;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ForceUpdateService {

    @Autowired
    private TerminalForceUpdateSchedulerRepository terminalForceUpdateSchedulerRepository;
    @Autowired
    private TerminalRepository terminalRepository;
    @Autowired
    private TerminalParameterRepository terminalParameterRepository;
    @Autowired
    private FuelProductRatesRepository fuelProductRatesRepository;
    @Autowired
    private FuelProductRepository fuelProductRepository;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    @Value("${subsidy.code}")
    private String subsidyCode;
    @Value("${account.key}")
    private String accountKey;

    @Scheduled(fixedRateString = "${scheduler.fixedDelay}")
    public void process() {
        Optional<List<TerminalForceUpdateScheduler>> terminalForceUpdateSchedulerOptionals = terminalForceUpdateSchedulerRepository.findByScheduledAtLessThanAndStatus(LocalDateTime.now(), ForceUpdateSchedulerStatus.NEW);

        if (!terminalForceUpdateSchedulerOptionals.isPresent() || terminalForceUpdateSchedulerOptionals.get().isEmpty()) {
            return;
        }

        for (TerminalForceUpdateScheduler terminalForceUpdateScheduler : terminalForceUpdateSchedulerOptionals.get()) {
            log.info("Scheduler Task Found  :  " + terminalForceUpdateScheduler);

            terminalForceUpdateScheduler.setStatus(ForceUpdateSchedulerStatus.IN_PROGRESS);
            terminalForceUpdateSchedulerRepository.save(terminalForceUpdateScheduler);

            try {
                List<Merchant> merchants = new ArrayList<>();
                if ("all".equalsIgnoreCase(terminalForceUpdateScheduler.getMerchantId())) {
                    merchants = merchantRepository.findAll();
                } else {
                    merchantRepository.findByMerchantId(terminalForceUpdateScheduler.getMerchantId()).ifPresent(merchants::add);
                }

                log.info("Updating Merchants:  " + merchants);

                List<Station> stations = new ArrayList<>();
                for (Merchant merchant : merchants) {
                    if ("all".equalsIgnoreCase(terminalForceUpdateScheduler.getStationId())) {
                        stationRepository.findByMerchantId(merchant.getMerchantId()).ifPresent(stations::addAll);
                    } else {
                        stationRepository.findByMerchantIdAndStationId(merchant.getMerchantId(), terminalForceUpdateScheduler.getStationId()).ifPresent(stations::add);
                    }
                }

                log.info("Updating Stations:   " + stations);

                List<Terminal> terminals = new ArrayList<>();
                for (Station station : stations) {
                    if ("all".equalsIgnoreCase(terminalForceUpdateScheduler.getTerminalId())) {
                        log.info("Updating Terminals for Station :  " + station);
                        terminalRepository.findByStationId(station.getStationId()).ifPresent(terminals::addAll);
                    } else {
                        log.info("Updating Terminal for Station :  " + station);
                        terminalRepository.findByTerminalId(terminalForceUpdateScheduler.getTerminalId()).ifPresent(terminals::add);
                    }
                }

                log.info("Updating Terminals   " + terminals);

                for (Terminal terminal : terminals) {
                    terminal.setForceUpdate(Boolean.TRUE);
                    terminal.setForceUpdateActivateTime(LocalDateTime.now());
                    terminalRepository.save(terminal);
                    log.info("Updating Terminal as force update :  " + terminal);

                    updateTerminalParameter(terminal, "MOGAS-91", ParamName.MOGAS91_RATE);
                    updateTerminalParameter(terminal, "MOGAS-95", ParamName.MOGAS95_RATE);
                    updateTerminalParameter(terminal, "DIESEL-GO", ParamName.DIESELGO_RATE);
                    updateTerminalParameter(terminal, "POWER-98", ParamName.POWER98_RATE);
                    updateTerminalParameter(terminal, "POWER-PLUS", ParamName.POWERPLUS_RATE);
                }

                terminalForceUpdateScheduler.setStatus(ForceUpdateSchedulerStatus.COMPLETED);
            } catch (Exception e) {
                log.error("Error Force Update  Failed", e);
                terminalForceUpdateScheduler.setStatus(ForceUpdateSchedulerStatus.FAILED);
            }
            terminalForceUpdateSchedulerRepository.save(terminalForceUpdateScheduler);
        }
    }

    private void updateTerminalParameter(Terminal terminal, String fuelProduct, ParamName paramName) {
        fuelProductRatesRepository.findByFuelProduct(fuelProduct).ifPresent(fuelProductRates -> {
            log.info("Fuel Product Rates :  " + fuelProductRates);
            Optional<TerminalParameter> terminalParameterOptional = terminalParameterRepository.findByTerminalIdAndParamName(terminal.getTerminalId(), paramName);
            TerminalParameter terminalParameter = terminalParameterOptional.orElseGet(() -> {
                TerminalParameter newTerminalParameter = new TerminalParameter();
                newTerminalParameter.setTerminalId(terminal.getTerminalId());
                newTerminalParameter.setParamName(paramName);
                return newTerminalParameter;
            });
            terminalParameter.setParamValue(fuelProductRates.getRate().toPlainString());
            terminalParameterRepository.save(terminalParameter);
            log.info((terminalParameterOptional.isPresent() ? "Updating" : "Creating") + " TerminalParam :  " + terminalParameter);
        });
    }
}
