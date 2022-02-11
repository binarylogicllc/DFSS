package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.CardWhitelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CardWhitelistRepository extends JpaRepository<CardWhitelist,String> {

    Optional<CardWhitelist> findByCardNumber(String cardNumber);

    Optional<CardWhitelist> findByCardUid(String cardUid);

    Optional<List<CardWhitelist>> findAllByFileName(String fileName);

    @Modifying
    @Transactional
    @Query(value = "delete from card_whitelist cw where cw.file_name = :fileName ", nativeQuery = true)
    int deleteAllByFileName(@Param("fileName") String fileName);

    @Query(value = "select cw.file_name from card_whitelist cw group by cw.file_name ", nativeQuery = true)
    List<String> getAllFileName();

}
