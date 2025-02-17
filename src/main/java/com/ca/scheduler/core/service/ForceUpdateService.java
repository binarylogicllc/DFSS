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

        if(!terminalForceUpdateSchedulerOptionals.isPresent() || terminalForceUpdateSchedulerOptionals.get().size() == 0 ){
            return;
        }

        for(TerminalForceUpdateScheduler terminalForceUpdateScheduler : terminalForceUpdateSchedulerOptionals.get()) {


            log.info("Scheduler Task Found  :  "+terminalForceUpdateScheduler);

            terminalForceUpdateScheduler.setStatus(ForceUpdateSchedulerStatus.IN_PROGRESS);
            terminalForceUpdateSchedulerRepository.save(terminalForceUpdateScheduler);

            try {
                List<Merchant> merchants = new ArrayList<>();
                if (terminalForceUpdateScheduler.getMerchantId() != null && terminalForceUpdateScheduler.getMerchantId().equals("All")) {
                    merchants = merchantRepository.findAll();
                } else {
                    merchants.add(merchantRepository.findByMerchantId(terminalForceUpdateScheduler.getMerchantId()).get());
                }

                log.info("Updating Merchants:  " + merchants);

                List<Station> stations = new ArrayList<>();

                for (Merchant merchant : merchants) {
                    if (terminalForceUpdateScheduler.getStationId() != null && terminalForceUpdateScheduler.getStationId().equals("All")) {
                       Optional<List<Station>> stationList = stationRepository.findByMerchantId(merchant.getMerchantId());
                       if(stationList.isPresent()) {
                           stations = stationList.get();
                       }
                    } else {
                        stations.add(stationRepository.findByMerchantIdAndStationId(merchant.getMerchantId(), terminalForceUpdateScheduler.getStationId()).get());
                    }
                }
                log.info("Updating Stations:   " + stations);

                List<Terminal> terminals = new ArrayList<>();
                for (Station station : stations) {
                    if (terminalForceUpdateScheduler.getTerminalId() != null && terminalForceUpdateScheduler.getTerminalId().equals("All")) {
                        Optional<List<Terminal>> terminalList = terminalRepository.findByStationId(station.getStationId());
                        if(terminalList.isPresent()) {
                            terminals = terminalList.get();
                        }
                    } else {
                        terminals.add(terminalRepository.findByTerminalId(terminalForceUpdateScheduler.getTerminalId()).get());
                    }
                }
                log.info("Updating Terminals   " + terminals);

                for (Terminal terminal : terminals) {

                    terminal.setForceUpdate(Boolean.TRUE);
                    terminal.setForceUpdateActivateTime(LocalDateTime.now());
                    terminalRepository.save(terminal);
                    log.info("Updating Terminal as force update :  " + terminal);

                    FuelProductRates fuelProductRatesMoGas91 = fuelProductRatesRepository.findByFuelProduct("MOGAS-91").get();
                    TerminalParameter terminalParameter = terminalParameterRepository.findByTerminalIdAndParamName(terminal.getTerminalId(), ParamName.MOGAS91_RATE).get();
                    terminalParameter.setParamValue(fuelProductRatesMoGas91.getRate().toPlainString());
                    terminalParameterRepository.save(terminalParameter);
                    log.info("Updating TerminalParam :  " + terminalParameter);

                    FuelProductRates fuelProductRatesMoGas95 = fuelProductRatesRepository.findByFuelProduct("MOGAS-95").get();
                    terminalParameter = terminalParameterRepository.findByTerminalIdAndParamName(terminal.getTerminalId(), ParamName.MOGAS95_RATE).get();
                    terminalParameter.setParamValue(fuelProductRatesMoGas95.getRate().toPlainString());
                    terminalParameterRepository.save(terminalParameter);
                    log.info("Updating TerminalParam :  " + terminalParameter);

                    FuelProductRates fuelProductRatesDieselGo = fuelProductRatesRepository.findByFuelProduct("DIESEL-GO").get();
                    terminalParameter = terminalParameterRepository.findByTerminalIdAndParamName(terminal.getTerminalId(), ParamName.DIESELGO_RATE).get();
                    terminalParameter.setParamValue(fuelProductRatesDieselGo.getRate().toPlainString());
                    terminalParameterRepository.save(terminalParameter);

                    log.info("Updating TerminalParam :  " + terminalParameter);
                }
                terminalForceUpdateScheduler.setStatus(ForceUpdateSchedulerStatus.COMPLETED);
            }catch (Exception e){
                log.error("Error Force Update  Failed",e);
                terminalForceUpdateScheduler.setStatus(ForceUpdateSchedulerStatus.FAILED);
            }
            terminalForceUpdateSchedulerRepository.save(terminalForceUpdateScheduler);
        }
    }

}
