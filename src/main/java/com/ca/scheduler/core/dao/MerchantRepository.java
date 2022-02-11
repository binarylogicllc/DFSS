package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Long>
{
    @Query("select m from Merchant m " +
            "where lower(m.name) like lower(concat('%', :searchTerm, '%')) ")
    List<Merchant> search(@Param("searchTerm") String searchTerm);

    @Query("select count(m) from Merchant m where m.active = 'Y'")
    Long findActiveCount();

    Optional<Merchant> findByMerchantId(String merchantId);
}