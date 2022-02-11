/**
 * 
 */
package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.AccountProduct;
import com.ca.scheduler.core.domain.values.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Pugazhendhi
 *
 */
public interface AccountProductRepository extends JpaRepository<AccountProduct, Long> {

    Optional<AccountProduct> findByProductCode(AccountType accountType);
}
