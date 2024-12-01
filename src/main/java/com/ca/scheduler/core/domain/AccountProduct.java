package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT_PRODUCT")
@Data
@EqualsAndHashCode(callSuper=false)
public class AccountProduct extends EntityAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_product_seq")
    @SequenceGenerator(
            name = "account_product_seq",
            sequenceName = "account_product_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "PRODUCT_CODE")
    @Enumerated(EnumType.STRING)
    private AccountType productCode;

    @Column(name = "PRODUCT_NAME")
    private String name;

}
