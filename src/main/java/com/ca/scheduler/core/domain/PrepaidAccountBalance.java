package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PREPAID_ACCOUNT_BALANCE")
@Data
@EqualsAndHashCode(callSuper=false)
public class PrepaidAccountBalance extends EntityAudit implements  AccountBalance{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prepaid_account_balance_seq")
    @SequenceGenerator(
            name = "prepaid_account_balance_seq",
            sequenceName = "prepaid_account_balance_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "AVAILABLE_AMOUNT")
    private BigDecimal availableAmount;

    @Column(name = "ONHOLD_AMOUNT")
    private BigDecimal onholdAmount;

    @Column(name = "ACCOUNT_NO")
    private String account;

    @Column(name = "SECURE_HASH")
    private String secureHash;

}
