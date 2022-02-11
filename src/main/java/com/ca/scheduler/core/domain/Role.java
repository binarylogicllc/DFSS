package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "ROLE" , schema = "public")
@Data
@EqualsAndHashCode(callSuper=false)
public class Role{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(
            name = "role_seq",
            sequenceName = "role_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "Name", unique = true)
    private String name;

}
