/**
 * 
 */
package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByAccountNumber(String accountNumber);
    Optional<List<Account>> findByCustomer(Long customerId);
}
