package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 * @author alienware
 * Create at 2021-11-21 00:09
 */
@Entity
@Table(name = "promotion")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Promotion extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotion_seq")
    @SequenceGenerator(
            name = "promotion_seq",
            sequenceName = "promotion_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "promo_title")
    private String promoTitle;

    @Column(name = "promo_prefix")
    private String promoPrefix;

    @Column(name = "promo_desc")
    private String promoDesc;

    @Column(name = "promo_code_length")
    private Integer promoCodeLength;

    @Type(type = "yes_no")
    @Column(name = "active")
    private Boolean active;

    @Column(name = "threshold_amt")
    private BigDecimal thresholdAmt;

    @Enumerated(EnumType.STRING)
    @Column(name = "promo_type")
    private PromoType promoType;

    @Column(name = "start_on", columnDefinition = "timestamp with time zone")
    private LocalDateTime startOn;

    @Column(name = "end_on", columnDefinition = "timestamp with time zone")
    private LocalDateTime endOn;

    @Type(type = "yes_no")
    @Column(name = "enable_subsidy")
    private Boolean enableSubsidy;

    @Type(type = "yes_no")
    @Column(name = "enable_corporate")
    private Boolean enableCorporate;

    @Type(type = "yes_no")
    @Column(name = "enable_prepaid")
    private Boolean enablePrepaid;

    @Type(type = "yes_no")
    @Column(name = "enable_cash")
    private Boolean enableCash;

    @Type(type = "yes_no")
    @Column(name = "allocate_coupon")
    private Boolean allocateCoupon;

    @Type(type = "yes_no")
    @Column(name = "allocate_points")
    private Boolean allocatePoints;

    @Column(name = "points_threshold_amount")
    private BigDecimal pointsThresholdAmt;

    @Column(name = "no_points")
    private Integer noPoints;

    @Column(name = "points_expiry")
    private Integer pointsExpiry;

}