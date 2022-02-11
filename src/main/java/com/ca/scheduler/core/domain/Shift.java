package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.ShiftStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "shift")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Shift  extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_seq")
    @SequenceGenerator(
            name = "shift_seq",
            sequenceName = "shift_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "shift_no", nullable = false)
    private String shiftNo;

    @Column(name = "attendant_id")
    private String attendantId;

    @Column(name = "shift_start_time")
    private LocalDateTime shiftStartTime;

    @Column(name = "shift_end_time")
    private LocalDateTime shiftEndTime;

    @Column(name = "shift_date")
    private LocalDate shiftDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ShiftStatus status;

    @Column(name = "terminal_id")
    private String terminal;

}