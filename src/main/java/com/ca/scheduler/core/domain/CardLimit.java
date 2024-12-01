package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_limit")
@Data
@EqualsAndHashCode(callSuper=false)
public class CardLimit extends EntityAudit implements  Cloneable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_limit_seq")
    @SequenceGenerator(
            name = "card_limit_seq",
            sequenceName = "card_limit_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "open_limit")
    private BigDecimal openLimit;

    @Column(name = "daily_limit")
    private BigDecimal dailyLimit;

    @Column(name = "daily_limit_start_date")
    private LocalDateTime dailyLimitStartDate;

    @Column(name = "daily_limit_end_date")
    private LocalDateTime dailyLimitEndDate;

    @Column(name = "weekly_limit")
    private BigDecimal weeklyLimit;

    @Column(name = "weekly_limit_start_date")
    private LocalDateTime weeklyLimitStartDate;

    @Column(name = "weekly_limit_end_date")
    private LocalDateTime weeklyLimitEndDate;

    @Column(name = "monthly_limit")
    private BigDecimal monthlyLimit;

    @Column(name = "monthly_limit_start_date")
    private LocalDateTime monthlyLimitStartDate;

    @Column(name = "monthly_limit_end_date")
    private LocalDateTime monthlyLimitEndDate;

    @Column(name = "yearly_limit")
    private BigDecimal yearlyLimit;

    @Column(name = "yearly_limit_start_date")
    private LocalDateTime yearlyLimitStartDate;

    @Column(name = "yearly_limit_end_date")
    private LocalDateTime yearlyLimitEndDate;

    @Column(name = "period_limit")
    private BigDecimal periodLimit;

    @Column(name = "period_limit_start_date")
    private LocalDateTime periodLimitStartDate;

    @Column(name = "period_limit_end_date")
    private LocalDateTime periodLimitEndDate;

    @Column(name = "revalue_limit")
    private BigDecimal revalueLimit;

    @Column(name = "no_txn_day")
    private Long noTxnDay;

    @Column(name = "txn_start_date")
    private LocalDateTime txnStartDate;

    @Column(name = "txn_end_date")
    private LocalDateTime txnEndDate;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
