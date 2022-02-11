package com.ca.scheduler.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "REASON_CODE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ReasonCode extends DomainBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reason_code_seq")
    @SequenceGenerator(
            name = "reason_code_seq",
            sequenceName = "reason_code_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "INT_CODE")
    private Integer intCode;
    @Column(name = "CODE")
    private String code;
    @Column(name = "REASON")
    private String reason;

}
