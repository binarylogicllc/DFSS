package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER" , schema = "public")
@Data
@EqualsAndHashCode(callSuper=false)
public class User extends DomainBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE")
    private UserType userType;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;

    @Type(type = "yes_no")
    @Column(name = "CREDS_EXPIRED")
    private Boolean credsExpired;

    @Type(type = "yes_no")
    @Column(name = "LOCKED")
    private Boolean locked;

    @Type(type = "yes_no")
    @Column(name = "DELETED")
    private Boolean deleted;

    @Type(type = "yes_no")
    @Column(name = "VERIFIED")
    private Boolean verified;

    @Column(name = "EXPIRY")
    private Integer expiry;

    @Type(type = "yes_no")
    @Column(name = "force_password_change")
    private Boolean forcePasswordChange;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "password_changed")
    private LocalDateTime passwordChanged;

    @Column(name = "login_attempts")
    private Integer loginAttempts;

    @Column(name = "device_id")
    private String deviceId;

    @Type(type = "yes_no")
    @Column(name = "device_validation")
    private Boolean deviceValidation;

}
