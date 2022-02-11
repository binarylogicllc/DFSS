package com.ca.scheduler.core.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fuel_product_rates")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class FuelProductRates extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fuel_product_rates_seq")
    @SequenceGenerator(
            name = "fuel_product_rates_seq",
            sequenceName = "fuel_product_rates_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "invoice_rate")
    private BigDecimal invoiceRate;

    @Column(name = "per_liter_fee")
    private BigDecimal perLiterFee;

    @Column(name = "rate_type")
    private String rateType;

    @Column(name = "nss_rate")
    private BigDecimal nssRate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "active")
    @Type(type = "yes_no")
    private Boolean active;

    @Column(name = "fuel_product")
    private String fuelProduct;
}