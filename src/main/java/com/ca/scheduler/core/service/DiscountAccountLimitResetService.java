package com.ca.scheduler.core.service;
import com.ca.scheduler.core.dao.SubsidyAccountBalanceRepository;
import com.ca.scheduler.core.dao.SubsidyProductRepository;
import com.ca.scheduler.core.domain.SubsidyAccountBalance;
import com.ca.scheduler.core.domain.SubsidyProduct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
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

    @PostConstruct
    public void runImmediately() {
        processImmediately();
    }

    @Transactional
    @Scheduled(cron = "0 0 0 1 1/1 *")
    public void process() {
        log.info("====================================START==========================================");
        log.info("DiscountAccountLimitResetService task started at: " + LocalDateTime.now());

        redisTemplate.opsForValue().set("MONTHLY::BATCH", "TRUE", 15, TimeUnit.MINUTES);
        log.info("BEFORE DELETE MONTHLY::BATCH VALUE: " + redisTemplate.opsForValue().get("MONTHLY::BATCH"));

        Optional<SubsidyProduct> subsidyProduct = subsidyProductRepository.findBySubsidyCode(subsidyCode);
        if (!subsidyProduct.isPresent()) {
            log.error("Subsidy product not found: " + subsidyCode);
            return;
        }

        int batchSize = 1000;
        int page = 0;

        while (true) {
            log.info("Processing batch page: " + page);
            var subsidyAccountBalances = subsidyAccountBalanceRepository.findAll(PageRequest.of(page, batchSize));
            if (!subsidyAccountBalances.hasContent()) {
                break;
            } else {
                log.info("Total records in this batch: " + subsidyAccountBalances.getNumberOfElements());
            }

            subsidyAccountBalances.forEach(subsidyAccountBalance -> {
                log.info("Before update: " + subsidyAccountBalance);
                subsidyAccountBalance.setAvailableLiter(subsidyAccountBalance.getAllocatedLiter());
                subsidyAccountBalance.setUpdatedAt(LocalDateTime.now());
                subsidyAccountBalance.setUpdatedBy("Batch");
                subsidyAccountBalance.setCurrentResetAt(LocalDateTime.now());
                subsidyAccountBalance.setNextResetAt(subsidyAccountBalance.getNextResetAt().plusMonths(1));
                subsidyAccountBalance.setSecureHash(computeHash(subsidyAccountBalance.getAvailableLiter() + "" + subsidyAccountBalance.getAccount()));
                subsidyAccountBalanceRepository.save(subsidyAccountBalance);
                log.info("After update: " + subsidyAccountBalance);
            });
            page++;
        }

        log.info("DiscountAccountLimitResetService task ended at: " + LocalDateTime.now());
        log.info("***********************************END*********************************************");
        redisTemplate.delete("MONTHLY::BATCH");
        log.info("AFTER DELETE MONTHLY::BATCH VALUE: " + redisTemplate.opsForValue().get("MONTHLY::BATCH"));
    }



    @Transactional
    public void processImmediately() {
        log.info("====================================START==========================================");
        log.info("LimitResetService task started at :  " + LocalDateTime.now());

        Optional<SubsidyProduct> subsidyProduct = subsidyProductRepository.findBySubsidyCode(subsidyCode);
        if (!subsidyProduct.isPresent()) {
            log.error("Subsidy product not found: " + subsidyCode);
            return;
        }

        int batchSize = 1000; // Number of records to process per batch
        int page = 0; // Start with the first page

        while (true) {
            log.info("Processing batch page: " + page);

            // Fetch records in batches
            var subsidyAccountBalances = subsidyAccountBalanceRepository.findAll(PageRequest.of(page, batchSize));
            if (!subsidyAccountBalances.hasContent()) {
                break;
            }else{
                log.info("Total records in this batch : "+subsidyAccountBalances.getNumberOfElements());
            }

            // Process each record in the batch
            subsidyAccountBalances.forEach(subsidyAccountBalance -> {
                log.info("Before LimitResetService Update  : " + subsidyAccountBalance);
                if (subsidyAccountBalance.getCurrentResetAt() != null && subsidyAccountBalance.getNextResetAt() != null &&
                        subsidyAccountBalance.getCurrentResetAt().isBefore(subsidyAccountBalance.getNextResetAt())
                        && subsidyAccountBalance.getNextResetAt().isBefore(LocalDateTime.now())) {
                    log.info("Resetting the limit for this account : " + subsidyAccountBalance.getAccount());
                    subsidyAccountBalance.setAvailableLiter(subsidyAccountBalance.getAllocatedLiter());
                    subsidyAccountBalance.setUpdatedAt(LocalDateTime.now());
                    subsidyAccountBalance.setUpdatedBy("Batch");
                    subsidyAccountBalance.setCurrentResetAt(LocalDateTime.now());
                    subsidyAccountBalance.setNextResetAt(subsidyAccountBalance.getNextResetAt().plusMonths(1));
                    subsidyAccountBalance.setSecureHash(computeHash(subsidyAccountBalance.getAvailableLiter() + "" + subsidyAccountBalance.getAccount()));
                    subsidyAccountBalanceRepository.save(subsidyAccountBalance);
                    log.info("After LimitResetService Update : " + subsidyAccountBalance);
                } else {
                    log.info("No need to reset the limit for this account : " + subsidyAccountBalance.getAccount());
                }
            });
            page++;
        }
        log.info("LimitResetService task ended at :  " + LocalDateTime.now());
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
