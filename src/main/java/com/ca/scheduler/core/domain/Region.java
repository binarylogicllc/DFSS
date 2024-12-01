package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "REGION" , schema = "public")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Region extends EntityAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
    @SequenceGenerator(
            name = "region_seq",
            sequenceName = "region_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "region_id")
    private String regionId;

    @Column(name = "region_name")
    private String regionName;

    @Type(type = "yes_no")
    @Column(name = "active")
    private Boolean active;

}
