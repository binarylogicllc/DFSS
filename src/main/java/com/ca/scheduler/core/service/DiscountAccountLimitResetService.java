package com.ca.scheduler.core.service;
import com.ca.scheduler.core.dao.SubsidyAccountBalanceRepository;
import com.ca.scheduler.core.dao.SubsidyProductRepository;
import com.ca.scheduler.core.domain.SubsidyAccountBalance;
import com.ca.scheduler.core.domain.SubsidyProduct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class DiscountAccountLimitResetService {

    @Autowired
    private SubsidyAccountBalanceRepository subsidyAccountBalanceRepository;

    @Autowired
    private SubsidyProductRepository subsidyProductRepository;

    @Value("${subsidy.code}")
    private String subsidyCode;

    @Value("${account.key}")
    private String accountKey;

    @Scheduled(cron="0 0 0 1 1/1 *")
    public void process() {
        log.info("====================================START==========================================");
        log.info("DiscountAccountLimitResetService task started at :  "+ LocalDateTime.now());

        Optional<SubsidyProduct> subsidyProduct = subsidyProductRepository.findBySubsidyCode(subsidyCode);
        if(!subsidyProduct.isPresent()){
            log.error("Subsidy product not  found : "+subsidyCode);
            return;
        }
        List<SubsidyAccountBalance> subsidyAccountBalanceList = subsidyAccountBalanceRepository.findAll();
        if(subsidyAccountBalanceList != null){
            for(SubsidyAccountBalance subsidyAccountBalance : subsidyAccountBalanceList){
                subsidyAccountBalance.setAvailableLiter(subsidyAccountBalance.getAllocatedLiter());
                subsidyAccountBalance.setUpdatedAt(LocalDateTime.now());
                subsidyAccountBalance.setUpdatedBy("Batch");
                subsidyAccountBalance.setSecureHash(computeHash(subsidyAccountBalance.getAvailableLiter()+""+subsidyAccountBalance.getAccount()));
                subsidyAccountBalanceRepository.save(subsidyAccountBalance);
                log.error("Updated Price : "+subsidyAccountBalance);
            }
        }
        log.info("DiscountAccountLimitResetService task ended at :  "+ LocalDateTime.now());
        log.info("***********************************END*********************************************");

    }

    public String computeHash(String data) {
        log.info("------ Compute  Hash (Account) ------");
        log.info("Data :"+ data);
        String hmac = new HmacUtils("HmacMD5", accountKey).hmacHex(data);
        log.info("hmac Value  : "+hmac);
        return hmac;
    }
}
