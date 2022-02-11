package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.SubsidyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface SubsidyProductRepository extends JpaRepository<SubsidyProduct, Long>, JpaSpecificationExecutor<SubsidyProduct> {

    Optional<SubsidyProduct> findBySubsidyCode(String subsidyCode);
}
