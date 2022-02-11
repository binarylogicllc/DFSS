package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROLE_PERMS" , schema = "public")
@Data
@EqualsAndHashCode(callSuper=false)
@Embeddable
public class RolePerm implements Serializable {
    
    @Id
    @Column(name = "ROLE")
    private Long role;

    @Id
    @Column(name = "NAME")
    private String name;

}
