package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    Optional<Transaction> findByTransactionRef(String transactionRef);

    @Query(value = "select count(*) as salecount , sum(t.approved_liter) as saleqty, sum(t.total_amount) as saleamt , sum(t.discount_amount) as disamt  from Transaction t where  t.pos_id = :posId and t.batch_no = :batchNo and t.status='COMPLETED' and t.authorize_date >= :batchDate ", nativeQuery = true)
    List<Object[]> findBatchSummary(@Param("posId") String posId , @Param("batchNo") String batchNo , @Param("batchDate") LocalDate batchDate);

}