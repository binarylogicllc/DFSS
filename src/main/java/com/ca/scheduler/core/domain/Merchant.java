package com.ca.scheduler.core.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "merchant")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Merchant  extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_seq")
    @SequenceGenerator(
            name = "merchant_seq",
            sequenceName = "merchant_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "name")
    private String name;

    @Column(name = "name_ar")
    private String nameAr;

    @Column(name = "reference", nullable = false)
    private String reference;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    @Type(type = "yes_no")
    private Boolean active;

    @Column(name = "vat_in")
    private String vatIn;

    @Column(name = "WEBSITE_URL")
    private String websiteURL;

    @Column(name = "address")
    private String address;

    @Column(name = "region")
    private String region;

    @Column(name = "wilayat")
    private String wilayat;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;


}