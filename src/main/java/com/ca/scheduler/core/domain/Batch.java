package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.BatchStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Batch  extends EntityAudit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_seq")
    @SequenceGenerator(
            name = "batch_seq",
            sequenceName = "batch_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "batch_no", nullable = false)
    private String batchNo;

    @Column(name = "discount_qty")
    private BigDecimal discountQty;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "sale_count")
    private Integer saleCount;

    @Column(name = "sale_qty")
    private BigDecimal saleQty;

    @Column(name = "sale_amount")
    private BigDecimal saleAmount;

    @Column(name = "void_sale_count")
    private Integer voidSaleCount;

    @Column(name = "void_sale_qty")
    private BigDecimal voidSaleQty;

    @Column(name = "void_sale_amount")
    private BigDecimal voidSaleAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BatchStatus status;

    @Column(name = "batch_date")
    private LocalDate batchDate;

    @Column(name = "batch_start_time")
    private LocalDateTime batchStartTime;

    @Column(name = "batch_end_time")
    private LocalDateTime batchEndTime;

    @Column(name = "fuel_product")
    private String fuelProduct;

    @Column(name = "terminal_id")
    private String terminal;

}