package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.PrepaidAccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrepaidAccountBalanceRepository extends JpaRepository<PrepaidAccountBalance,Long> {

    Optional<PrepaidAccountBalance> findByAccount(String account);
}
