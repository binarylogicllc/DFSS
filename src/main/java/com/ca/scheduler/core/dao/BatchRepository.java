package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, Long>
{
    Optional<List<Batch>> findByBatchNoAndTerminal(String batchNo, String terminal);
}