package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.TerminalWhitelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TerminalWhitelistRepository extends JpaRepository<TerminalWhitelist,String> {

    Optional<TerminalWhitelist> findByDeviceSerial(String deviceSerial);

    @Modifying
    @Transactional
    @Query(value = "delete from terminal_whitelist cw where cw.file_name = :fileName ", nativeQuery = true)
    int deleteAllByFileName(@Param("fileName") String fileName);

    @Query(value = "select cw.file_name from terminal_whitelist cw group by cw.file_name ", nativeQuery = true)
    List<String> getAllFileName();

}
