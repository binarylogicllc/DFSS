package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.CardProduct;
import com.ca.scheduler.core.domain.values.CardProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardProductRepository extends JpaRepository<CardProduct, CardProductType> {
    Optional<CardProduct> findByProduct(CardProductType product);
}
