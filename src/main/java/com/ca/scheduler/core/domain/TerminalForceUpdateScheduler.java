package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "terminal_force_update_scheduler")
@Data
@EqualsAndHashCode(callSuper=false)
public class TerminalForceUpdateScheduler extends EntityAudit{

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_force_update_seq")
    @SequenceGenerator(
            name = "terminal_force_update_seq",
            sequenceName = "terminal_force_update_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "MERCHANT_ID")
    private String merchantId;

    @Column(name = "STATION_ID")
    private String stationId;

    @Column(name = "TERMINAL_ID")
    private String terminalId;

    @Column(name = "SCHEDULED_AT")
    private LocalDateTime scheduledAt;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private ForceUpdateSchedulerStatus status;

    @Column(name = "CRON_EXPRESSION")
    private String cronExpression;

}
