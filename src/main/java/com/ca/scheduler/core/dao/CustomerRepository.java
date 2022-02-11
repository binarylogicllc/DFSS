/**
 * 
 */
package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Customer;
import com.ca.scheduler.core.domain.values.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @author Pugazhendhi
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    Optional<Customer> findById(Long id);
    Optional<Customer> findByCustomerCode(String customerCode);
    List<Customer> findByCustomerType(CustomerType c);
    Optional<Customer> findByPhone(String phone);
    Optional<Customer> findByCitizenId(String citizenId);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByPhoneAndCitizenId(String phone, String citizenId);
}
