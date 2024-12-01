package com.ca.scheduler.core.domain;

import lombok.*;

import javax.persistence.*;

/**
 * 
 * @author alienware
 * Create at 2021-11-21 00:09
 */
@Entity
@Table(name = "released_terminal")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class ReleasedTerminal extends DomainBase {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "released_terminal_seq")
    @SequenceGenerator(
            name = "released_terminal_seq",
            sequenceName = "released_terminal_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "device_serial")
    private String deviceSerial;

    @Column(name = "old_terminal_id")
    private String oldTerminalId;

}