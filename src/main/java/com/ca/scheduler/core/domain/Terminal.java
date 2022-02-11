package com.ca.scheduler.core.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 
 * @author alienware
 * Create at 2021-11-21 00:09
 */
@Entity
@Table(name = "terminal")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Terminal  extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_seq")
    @SequenceGenerator(
            name = "terminal_seq",
            sequenceName = "terminal_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "terminal_id", nullable = false)
    private String terminalId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "device_serial")
    private String deviceSerial;

    @Column(name = "soft_version")
    private String softVersion;

    @Column(name = "force_update")
    @Type(type = "yes_no")
    private Boolean forceUpdate;

    @Column(name = "skip_batch_validation")
    @Type(type = "yes_no")
    private Boolean skipBatchValidation;

    @Column(name = "force_update_activate_time")
    private LocalDateTime forceUpdateActivateTime;

    @Column(name = "last_force_updated_time")
    private LocalDateTime lastForceUpdatedTime;

    @Column(name = "last_found_time")
    private LocalDateTime lastFoundTime;

    @Column(name = "active")
    @Type(type = "yes_no")
    private Boolean active;

    @Column(name = "station_id")
    private String stationId;

    @Column(name = "merchant_id")
    private String merchantId;
}