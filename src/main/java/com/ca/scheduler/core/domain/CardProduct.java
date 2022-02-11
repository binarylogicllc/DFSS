package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.CardProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CARD_PRODUCT")
@Data
@EqualsAndHashCode(callSuper=false)
public class CardProduct extends DomainBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_prd_seq")
    @SequenceGenerator(
            name = "card_prd_seq",
            sequenceName = "card_prd_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "product")
    private CardProductType product;

    @Column(name = "BIN")
    private Long bin;

    @Column(name = "START_RANGE")
    private Long startRange;

    @Column(name = "END_RANGE")
    private Long endRange;

    @Column(name = "MONTHLY_LIMIT")
    private BigDecimal monthlyLimit;

    @Type(type = "yes_no")
    @Column(name = "PIN_REQUIRED")
    private Boolean pinRequired;

    @Type(type = "yes_no")
    @Column(name = "MILEAGE_REQUIRED")
    private Boolean mileageRequired;

    @Type(type = "yes_no")
    @Column(name = "VEHICLE_NO_CHECK")
    private Boolean vehicleNoCheck;

    @Type(type = "yes_no")
    @Column(name = "LIMIT_ON_QUANTITY")
    private Boolean limitOnQuantity;

    @Column(name = "REMINDER_MONTHLY_LIMIT")
    private String reminderMonthlyLimit;

    @Column(name = "PRODUCT_ALLOWED")
    private String productAllowed;

    @Column(name = "PRODUCT_LIMIT_CHECK")
    private String productLimitCheck;

    @Type(type = "yes_no")
    @Column(name = "REGION_RESTRICTION")
    private Boolean regionRestriction;

    @Column(name = "REGION")
    private String region;

    @Column(name = "NEW_ACTIVATION_FEE")
    private BigDecimal newActivationFee;

    @Column(name = "LOST_ACTIVATION_FEE")
    private BigDecimal lostActivationFee;

    @Column(name = "DAMAGE_ACTIVATION_FEE")
    private BigDecimal damageActivationFee;

    @Column(name = "expiry")
    private Long expiry;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

}
