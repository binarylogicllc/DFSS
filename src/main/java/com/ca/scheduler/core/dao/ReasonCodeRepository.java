package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.ReasonCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReasonCodeRepository extends JpaRepository<ReasonCode,Long> {
    Optional<ReasonCode> findByCode(String code);
}
