package com.ca.scheduler.core.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * 
 * @author alienware
 * Create at 2021-11-21 00:09
 */
@Entity
@Table(name = "terminal_parameter")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class TerminalParameter extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_parameter_seq")
    @SequenceGenerator(
            name = "terminal_parameter_seq",
            sequenceName = "terminal_parameter_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "terminal_id", nullable = false)
    private String terminalId;

    @Column(name = "param_name")
    private String paramName;

    @Column(name = "param_value")
    private String paramValue;

    @Column(name = "is_global")
    @Type(type = "yes_no")
    private Boolean global;

    @Column(name = "active")
    @Type(type = "yes_no")
    private Boolean active;

}