package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "DEVICE" , schema = "public")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Device  extends EntityAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_seq")
    @SequenceGenerator(
            name = "device_seq",
            sequenceName = "device_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "fcm_token")
    private String fcmToken;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "os_version")
    private String osVersion;

    @Type(type = "yes_no")
    @Column(name = "active")
    private Boolean active;

    @Override
    public  String toString(){
        return userId+"-"+customerId+"-"+deviceId;
    }
}
