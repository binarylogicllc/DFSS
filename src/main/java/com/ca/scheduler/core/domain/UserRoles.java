package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_ROLES" , schema = "public")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class UserRoles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(
            name = "user_role_seq",
            sequenceName = "user_role_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "user_id")
    private Long user;

    @Column(name = "role_id")
    private Long role;

    @Override
    public  String toString(){
        return user+"-"+role;
    }
}
