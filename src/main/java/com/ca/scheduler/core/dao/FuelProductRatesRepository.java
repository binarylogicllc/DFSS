package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.FuelProductRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FuelProductRatesRepository extends JpaRepository<FuelProductRates, Long>
{

    @Query("select fpr from FuelProductRates fpr " +
            "where fpr.fuelProduct like lower(concat('%', :searchTerm, '%')) ")
    List<FuelProductRates> search(@Param("searchTerm") String searchTerm);

    Optional<FuelProductRates> findByFuelProduct(String fuelProduct);
}