package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_restriction")
@Data
@EqualsAndHashCode(callSuper=false)
public class CardRestriction extends DomainBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_restriction_seq")
    @SequenceGenerator(
            name = "card_restriction_seq",
            sequenceName = "card_restriction_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "card_no")
    private String cardNo;

    @Type(type = "yes_no")
    @Column(name = "limit_on_quantity")
    private Boolean limitOnQuantity;

    @Type(type = "yes_no")
    @Column(name = "limit_on_amount")
    private Boolean limitOnAmount;


    @Column(name = "open_limit")
    private BigDecimal openLimit;

    @Column(name = "filling_limit")
    private BigDecimal fillingLimit;

    @Column(name = "daily_limit")
    private BigDecimal dailyLimit;

    @Column(name = "weekly_limit")
    private BigDecimal weeklyLimit;

    @Column(name = "monthly_limit")
    private BigDecimal monthlyLimit;

    @Column(name = "yearly_limit")
    private BigDecimal yearlyLimit;

    @Column(name = "period_limit")
    private BigDecimal periodLimit;

    @Column(name = "start_period")
    private LocalDateTime startPeriod;

    @Column(name = "end_period")
    private LocalDateTime endPeriod;

    @Type(type = "yes_no")
    @Column(name = "day_restriction")
    private Boolean dayRestriction;

    @Column(name = "day_list")
    private String dayList;

    @Type(type = "yes_no")
    @Column(name = "time_restriction")
    private Boolean timeRestriction;

    @Column(name = "time_list")
    private String timeList;

    @Column(name = "revalue_limit")
    private BigDecimal revalueLimit;

    @Column(name = "floor_limit")
    private BigDecimal floorLimit;

    @Column(name = "no_txn_day")
    private Long noTxnDay;

    @Type(type = "yes_no")
    @Column(name = "vehicle_number_check")
    private Boolean vehicleNumberCheck;

    @Column(name = "vehicle_list")
    private String vehicleList;

    @Column(name = "vehicle_region_list")
    private String vehicleRegionList;

    @Type(type = "yes_no")
    @Column(name = "site_restriction")
    private Boolean siteRestriction;

    @Column(name = "site_list")
    private String siteList;

    @Type(type = "yes_no")
    @Column(name = "region_restriction")
    private Boolean regionRestriction;

    @Column(name = "region_list")
    private String regionList;

    @Type(type = "yes_no")
    @Column(name = "mileage_required")
    private Boolean mileageRequired;

    @Column(name = "odometer_reading")
    private BigDecimal odometerReading;

    @Type(type = "yes_no")
    @Column(name = "product_check")
    private Boolean productCheck;

    @Column(name = "product_list")
    private String productList;

    @Type(type = "yes_no")
    @Column(name = "pin_required")
    private Boolean pinRequired;

    @Column(name = "PIN")
    private String pin;


}
