package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.SubsidyAccountBalance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SubsidyAccountBalanceRepository extends JpaRepository<SubsidyAccountBalance,Long> {

    Optional<SubsidyAccountBalance> findByAccount(String account);

    Page<SubsidyAccountBalance> findByNextResetAtBefore(LocalDateTime nextResetAt, PageRequest pageRequest);

}
