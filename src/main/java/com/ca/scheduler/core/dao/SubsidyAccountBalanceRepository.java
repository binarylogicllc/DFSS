package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.SubsidyAccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubsidyAccountBalanceRepository extends JpaRepository<SubsidyAccountBalance,Long> {

    Optional<SubsidyAccountBalance> findByAccount(String account);
}
