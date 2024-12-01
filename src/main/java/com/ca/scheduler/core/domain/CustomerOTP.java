package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER_OTP")
@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerOTP extends EntityAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_otp_seq")
    @SequenceGenerator(
            name = "customer_otp_seq",
            sequenceName = "customer_otp_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name =  "customer_id")
    private Long customerId;

    @Column(name =  "otp_password")
    private String otpPassword;

    @Column(name = "otp_ref")
    private String otpRef;

    @Type(type = "yes_no")
    @Column(name =  "used")
    private Boolean used;

    @Column(name = "expiry")
    private LocalDateTime expiry;

}
