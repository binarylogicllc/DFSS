package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.QrType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "QRCODE")
@Data
@EqualsAndHashCode(callSuper=false)
public class QrCode extends DomainBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qr_seq")
    @SequenceGenerator(
            name = "qr_seq",
            sequenceName = "qr_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "QR_REF")
    private String qrRef;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private QrType qrType;

    @Column(name = "CODE")
    private String code;

    @Column(name = "account_number")
    private String account;

    @Column(name = "CUSTOMER_ID")
    private Long customer;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;

    @Type(type = "yes_no")
    @Column(name = "USED")
    private Boolean used;

    @Column(name = "SIGNATURE")
    private String signature;

    @Column(name = "EXPIRY")
    private LocalDateTime expiry;
}
