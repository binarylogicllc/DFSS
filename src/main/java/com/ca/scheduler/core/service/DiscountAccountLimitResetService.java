package com.ca.scheduler.core.service;
import com.ca.scheduler.core.dao.SubsidyAccountBalanceRepository;
import com.ca.scheduler.core.dao.SubsidyProductRepository;
import com.ca.scheduler.core.domain.SubsidyAccountBalance;
import com.ca.scheduler.core.domain.SubsidyProduct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Scheduled(cron="0 0 0 1 1/1 *")
    @Transactional
    public void process() {
        log.info("====================================START==========================================");
        log.info("DiscountAccountLimitResetService task started at :  "+ LocalDateTime.now());

        redisTemplate.opsForValue().set("MONTHLY::BATCH","TRUE",15, TimeUnit.MINUTES);
        log.info("BEFORE DELETE MONTHLY::BATCH VALUE  : "+redisTemplate.opsForValue().get("MONTHLY::BATCH"));
        Optional<SubsidyProduct> subsidyProduct = subsidyProductRepository.findBySubsidyCode(subsidyCode);
        if(!subsidyProduct.isPresent()){
            log.error("Subsidy product not  found : "+subsidyCode);
            return;
        }
        List<SubsidyAccountBalance> subsidyAccountBalanceList = subsidyAccountBalanceRepository.findAll();
        if(subsidyAccountBalanceList != null){
            for(SubsidyAccountBalance subsidyAccountBalance : subsidyAccountBalanceList){
                log.info("before update price reset by batch : "+subsidyAccountBalance);
                if(subsidyAccountBalance.getCurrentResetAt() != null && subsidyAccountBalance.getNextResetAt() != null
                        && LocalDateTime.now().isAfter(subsidyAccountBalance.getNextResetAt()) && subsidyAccountBalance.getCurrentResetAt().isBefore(subsidyAccountBalance.getNextResetAt())) {
                    subsidyAccountBalance.setAvailableLiter(subsidyAccountBalance.getAllocatedLiter());
                    subsidyAccountBalance.setUpdatedAt(LocalDateTime.now());
                    subsidyAccountBalance.setUpdatedBy("Batch");
                    subsidyAccountBalance.setCurrentResetAt(LocalDateTime.now());
                    subsidyAccountBalance.setNextResetAt(subsidyAccountBalance.getNextResetAt().plusMonths(1));
                    subsidyAccountBalance.setSecureHash(computeHash(subsidyAccountBalance.getAvailableLiter()+""+subsidyAccountBalance.getAccount()));
                    subsidyAccountBalanceRepository.save(subsidyAccountBalance);
                    log.info("After update price reset by batch : "+subsidyAccountBalance);
                }
            }
        }
        log.info("DiscountAccountLimitResetService task ended at :  "+ LocalDateTime.now());
        log.info("***********************************END*********************************************");
        redisTemplate.delete("MONTHLY::BATCH");
        log.info("AFTER DELETE MONTHLY::BATCH VALUE : "+redisTemplate.opsForValue().get("MONTHLY::BATCH"));
    }

    public String computeHash(String data) {
        log.info("------ Compute  Hash (Account) ------");
        log.info("Data :"+ data);
        String hmac = new HmacUtils("HmacMD5", accountKey).hmacHex(data);
        log.info("hmac Value  : "+hmac);
        return hmac;
    }

}
