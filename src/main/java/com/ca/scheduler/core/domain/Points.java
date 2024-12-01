package com.ca.scheduler.core.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 
 * @author alienware
 * Create at 2021-11-21 00:09
 */
@Entity
@Table(name = "points")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Points extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "points_seq")
    @SequenceGenerator(
            name = "points_seq",
            sequenceName = "points_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customer;

    @Column(name = "ACCOUNT_NO")
    private String account;

    @Column(name = "available_points")
    private Integer availablePoints;

    @Column(name = "collected_month")
    private LocalDate collectedMonth;

    @Column(name = "expiry_month")
    private LocalDate expiryMonth;

    @Column(name = "status")
    private String status;

}