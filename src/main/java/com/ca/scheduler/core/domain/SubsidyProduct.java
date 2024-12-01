package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "subsidy_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SubsidyProduct extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subsidy_product_seq")
    @SequenceGenerator(
            name = "subsidy_product_seq",
            sequenceName = "subsidy_product_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "subsidy_code")
    private String subsidyCode;

    @Column(name = "subsidy_name")
    private String subsidyName;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_rate")
    private BigDecimal discountRate;

    @Column(name = "limit_qty")
    private BigDecimal limit_qty;

    @Enumerated(EnumType.STRING)
    @Column(name = "subsidy_type")
    private SubsidyType subsidyType;

    @Column(name = "active")
    @Type(type = "yes_no")
    private Boolean active;

    @Column(name = "fuel_product")
    private String fuelProduct;

    @Column(name = "merchant")
    private String merchant;

}