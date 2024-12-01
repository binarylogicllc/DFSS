package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER")
@Data
@EqualsAndHashCode(callSuper=false)
public class Customer extends EntityAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(
            name = "customer_seq",
            sequenceName = "customer_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name =  "CUSTOMER_CODE")
    private String customerCode;

    @Column(name =  "PHONE")
    private String phone;

    @Column(name =  "EMAIL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "CITIZEN_ID")
    private String citizenId;

    @Column(name = "PASSPORT_NUM")
    private String passportNum;

    @Enumerated(EnumType.STRING)
    @Column(name = "CUSTOMER_TYPE")
    private CustomerType customerType;

    @Column(name = "RECEIVED_DATE_TIME",columnDefinition = "TIMESTAMP")
    private LocalDateTime receivedDateTime;

    @Column(name = "MOG_REPORTED_TIME",columnDefinition = "TIMESTAMP")
    private LocalDateTime mogReportedTime;

    private String subsidyCode;

    @Column(name = "REGISTRATION_REGION")
    private String registrationRegion;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    @Column(name = "VEHICLE_CODE")
    private String vehicleCode;

    @Type(type = "yes_no")
    @Column(name = "issue_card")
    private Boolean issueCard;

    @Type(type = "yes_no")
    @Column(name = "card_issued")
    private Boolean cardIssued;

    @Type(type = "yes_no")
    @Column(name = "virtual_card_issued")
    private Boolean virtualCardIssued;

    @Type(type = "yes_no")
    @Column(name = "card_lost")
    private Boolean cardLost;

    @Type(type = "yes_no")
    @Column(name = "card_damaged")
    private Boolean cardDamaged;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;

    @Type(type = "yes_no")
    @Column(name = "deleted")
    private Boolean deleted;

    @Type(type = "yes_no")
    @Column(name = "suspended")
    private Boolean suspended;

    @Column(name = "activation_end_date",columnDefinition = "TIMESTAMP")
    private LocalDateTime activationEndDate;

    @Column(name = "subsidy_card_expiry_date",columnDefinition = "TIMESTAMP")
    private LocalDateTime subsidyCardExpiryDate;

    @Column(name = "allowed_monthly_limit")
    private BigDecimal allowedMonthlyLimit;

    @Column(name = "available_monthly_limit")
    private BigDecimal availableMonthlyLimit;

    @Type(type = "yes_no")
    @Column(name = "is_prepaid")
    private Boolean isPrepaid;

    @Type(type = "yes_no")
    @Column(name = "is_corporate")
    private Boolean isCorporate;

    @Type(type = "yes_no")
    @Column(name = "is_individual")
    private Boolean isIndividual;

    @Type(type = "yes_no")
    @Column(name = "old_system")
    private Boolean oldSystem;

    @Column(name = "global_monthly_limit")
    private BigDecimal globalMonthlyLimit;

    @Column(name = "DOB")
    private String dob;

    @Type(type = "yes_no")
    @Column(name = "nss_suspended")
    private Boolean nssSuspended;

    @Type(type = "yes_no")
    @Column(name = "prepaid_suspended")
    private Boolean prepaidSuspended;

    @Type(type = "yes_no")
    @Column(name = "corporate_suspended")
    private Boolean corporateSuspended;

    @Type(type = "yes_no")
    @Column(name = "is_prepaid_virtual_card_issued")
    private Boolean isPrepaidVirtualCardIssued;

    @Type(type = "yes_no")
    @Column(name = "is_fleet_plus")
    private Boolean isFleetPlus;
}
