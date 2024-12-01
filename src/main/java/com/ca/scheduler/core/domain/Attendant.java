package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "attendant")
@Data
@EqualsAndHashCode(callSuper=false)
public class Attendant extends DomainBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendant_seq")
    @SequenceGenerator(
            name = "attendant_seq",
            sequenceName = "attendant_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "attendant_id")
    private String attendantId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Type(type = "yes_no")
    @Column(name = "active")
    private Boolean active;

    @Column(name = "station_id")
    private String stationId;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "pos_id_list")
    private String posIdList;
}
