package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.CustomerType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @Column(name = "RECEIVED_DATE_TIME")
    private LocalDateTime receivedDateTime;

    @Column(name = "MOG_REPORTED_TIME")
    private LocalDateTime mogReportedTime;

    private String subsidyCode;

    @Column(name = "REGISTRATION_REGION")
    private String registrationRegion;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    @Type(type = "yes_no")
    @Column(name = "issue_card")
    private Boolean issueCard;

    @Type(type = "yes_no")
    @Column(name = "card_issued")
    private Boolean cardIssued;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;

    @Type(type = "yes_no")
    @Column(name = "deleted")
    private Boolean deleted;

}
