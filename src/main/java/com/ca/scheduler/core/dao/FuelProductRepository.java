package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.FuelProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelProductRepository extends JpaRepository<FuelProduct, Long>
{
    Optional<FuelProduct> findByProductId(String productId);
}