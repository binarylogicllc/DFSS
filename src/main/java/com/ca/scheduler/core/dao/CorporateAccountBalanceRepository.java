package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.CorporateAccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorporateAccountBalanceRepository extends JpaRepository<CorporateAccountBalance,Long> {

    Optional<CorporateAccountBalance> findByAccount(String account);

}
