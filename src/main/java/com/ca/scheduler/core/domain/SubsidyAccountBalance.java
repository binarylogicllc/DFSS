package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SUBSIDY_ACCOUNT_BALANCE")
@Data
@EqualsAndHashCode(callSuper=false)
public class SubsidyAccountBalance extends EntityAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subsidy_account_balance_seq")
    @SequenceGenerator(
            name = "subsidy_account_balance_seq",
            sequenceName = "subsidy_account_balance_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "ALLOCATED_LITER")
    private BigDecimal allocatedLiter;

    @Column(name = "AVAILABLE_LITER")
    private BigDecimal availableLiter;

    @Column(name = "ONHOLD_LITER")
    private BigDecimal onholdLiter;

    @Column(name = "ACCOUNT_NO")
    private String account;

    @Column(name = "SECURE_HASH")
    private String secureHash;
}
