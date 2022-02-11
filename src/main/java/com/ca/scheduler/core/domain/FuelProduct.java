package com.ca.scheduler.core.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "fuel_product")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class FuelProduct  extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fuel_product_seq")
    @SequenceGenerator(
            name = "fuel_product_seq",
            sequenceName = "fuel_product_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    @Type(type = "yes_no")
    private Boolean active;

    @Column(name = "merchant")
    private String merchant;

}