package com.ca.scheduler.core.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "station")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Station  extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "station_seq")
    @SequenceGenerator(
            name = "station_seq",
            sequenceName = "station_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "station_id")
    private String stationId;

    @Column(name = "name")
    private String name;

    @Column(name = "reference", nullable = false)
    private String reference;

    @Column(name = "address")
    private String address;

    @Column(name = "region")
    private String region;

    @Column(name = "wilayat")
    private String wilayat;

    @Column(name = "contact_no")
    private String contact_no;

    @Column(name = "vat_in")
    private String vatIn;

    @Column(name = "email")
    private String email;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "active")
    @Type(type = "yes_no")
    private Boolean active;

    @Column(name = "car_wash")
    @Type(type = "yes_no")
    private Boolean carWash;

    @Column(name = "c_store")
    @Type(type = "yes_no")
    private Boolean cstore;

    @Column(name = "atm")
    @Type(type = "yes_no")
    private Boolean atm;

    @Column(name = "fuel_m98")
    @Type(type = "yes_no")
    private Boolean fuelM98;

    @Column(name = "repair_workshop")
    @Type(type = "yes_no")
    private Boolean repairWorkshop;


    @Column(name = "merchant_id")
    private String merchantId;

}