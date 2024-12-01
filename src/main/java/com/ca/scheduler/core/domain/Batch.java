package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
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

    @Column(name = "batch_date",columnDefinition = "DATE")
    private LocalDate batchDate;

    @Column(name = "batch_start_time",columnDefinition = "TIMESTAMP")
    private LocalDateTime batchStartTime;

    @Column(name = "batch_end_time",columnDefinition = "TIMESTAMP")
    private LocalDateTime batchEndTime;

    @Column(name = "fuel_product")
    private String fuelProduct;

    @Column(name = "terminal_id")
    private String terminal;

    @Column(name = "card_activation_count")
    private Integer cardActivationCount;

    @Column(name = "card_activation_fee")
    private BigDecimal cardActivationFee;

    @Column(name = "total_count")
    private Integer totalCount;

    @Column(name = "total_qty")
    private BigDecimal totalQty;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;



    @Column(name = "subsidy_card_activate_fee_amt")
    private BigDecimal subsidyCardActivateFeeAmt;
    @Column(name = "subsidy_card_activate_count")
    private Integer subsidyCardActivateCount;
    @Column(name = "subsidy_sale_count")
    private Integer subsidySaleCount;

    @Column(name = "subsidy_sale_qty")
    private BigDecimal subsidySaleQty;
    @Column(name = "subsidy_sale_amt")
    private BigDecimal subsidySaleAmt;

    @Column(name = "void_subsidy_sale_count")
    private Integer voidSubsidySaleCount;
    @Column(name = "void_subsidy_sale_qty")
    private BigDecimal voidSubsidySaleQty;
    @Column(name = "void_subsidy_sale_amt")
    private BigDecimal voidSubsidySaleAmt;
    @Column(name = "subsidy_discount_qty")
    private BigDecimal subsidyDiscountQty;
    @Column(name = "subsidy_discount_amt")
    private BigDecimal subsidyDiscountAmt;
    @Column(name = "subsidy_total_count")
    private Integer subsidyTotalCount;
    @Column(name = "subsidy_total_amt")
    private BigDecimal subsidyTotalAmt;
    @Column(name = "subsidy_total_qty")
    private BigDecimal subsidyTotalQty;
    @Column(name = "subsidy_total_round_off_amt")
    private BigDecimal subsidyTotalRoundOffAmt = BigDecimal.ZERO;
    @Column(name = "corp_card_act_fee_amt")
    private BigDecimal corporateCardActivateFeeAmt =  BigDecimal.ZERO;
    @Column(name = "corp_card_act_cnt")
    private Integer corporateCardActivateCount;
    @Column(name = "corp_sale_count")
    private Integer corporateSaleCount;
    @Column(name = "corp_sale_qty")
    private BigDecimal corporateSaleQty;
    @Column(name = "corp_sale_amt")
    private BigDecimal corporateSaleAmt;
    @Column(name = "void_corp_sale_count")
    private Integer voidCorporateSaleCount;
    @Column(name = "void_corp_sale_qty")
    private BigDecimal voidCorporateSaleQty;
    @Column(name = "void_corp_sale_amt")
    private BigDecimal voidCorporateSaleAmt;
    @Column(name = "corp_total_count")
    private Integer corporateTotalCount;
    @Column(name = "corp_total_amt")
    private BigDecimal corporateTotalAmt;
    @Column(name = "corp_total_qty")
    private BigDecimal corporateTotalQty;
    @Column(name = "corp_total_round_off_amt")
    private BigDecimal corporateTotalRoundOffAmt;
    @Column(name = "prepaid_card_act_fee_amt")
    private BigDecimal prepaidCardActivateFeeAmt;
    @Column(name = "prepaid_card_act_cnt")
    private Integer prepaidCardActivateCount;
    @Column(name = "prepaid_sale_cnt")
    private Integer prepaidSaleCount;
    @Column(name = "prepaid_sale_qty")
    private BigDecimal prepaidSaleQty;
    @Column(name = "prepaid_sale_amt")
    private BigDecimal prepaidSaleAmt;
    @Column(name = "void_prepaid_sale_cnt")
    private Integer voidPrepaidSaleCount;
    @Column(name = "void_prepaid_sale_qty")
    private BigDecimal voidPrepaidSaleQty;
    @Column(name = "void_prepaid_sale_amt")
    private BigDecimal voidPrepaidSaleAmt;
    @Column(name = "prepaid_topup_cnt")
    private Integer prepaidTopupCount;
    @Column(name = "prepaid_topup_qty")
    private BigDecimal prepaidTopupQty;
    @Column(name = "prepaid_topup_amt")
    private BigDecimal prepaidTopupAmt;
    @Column(name = "prepaid_total_count")
    private Integer prepaidTotalCount;
    @Column(name = "prepaid_total_amt")
    private BigDecimal prepaidTotalAmt;
    @Column(name = "prepaid_total_qty")
    private BigDecimal prepaidTotalQty;
    @Column(name = "prepaid_total_round_off_amt")
    private BigDecimal prepaidTotalRoundOffAmt;

    @Column(name = "cash_sale_cnt")
    private Integer cashSaleCount;
    @Column(name = "cash_sale_qty")
    private BigDecimal cashSaleQty;
    @Column(name = "cash_sale_amt")
    private BigDecimal cashSaleAmt;
    @Column(name = "void_cash_sale_cnt")
    private Integer voidCashSaleCount;
    @Column(name = "void_cash_sale_qty")
    private BigDecimal voidCashSaleQty;
    @Column(name = "void_cash_sale_amt")
    private BigDecimal voidCashSaleAmt;
    @Column(name = "cash_total_count")
    private Integer cashTotalCount;
    @Column(name = "cash_total_amt")
    private BigDecimal cashTotalAmt;
    @Column(name = "cash_total_qty")
    private BigDecimal cashTotalQty;

    @Column(name = "mogas_91_amt")
    private BigDecimal mogas91Amt;
    @Column(name = "mogas_91_qty")
    private BigDecimal mogas91Qty;
    @Column(name = "mogas_95_amt")
    private BigDecimal mogas95Amt ;
    @Column(name = "mogas_95_qty")
    private BigDecimal mogas95Qty;
    @Column(name = "diesel_go_amt")
    private BigDecimal dieselGoAmt;
    @Column(name = "diesel_go_qty")
    private BigDecimal dieselGoQty;
    @Column(name = "lube_amt")
    private BigDecimal lubeAmt;
    @Column(name = "lube_qty")
    private BigDecimal lubeQty;
    @Column(name = "car_amt")
    private BigDecimal carAmt;
    @Column(name = "car_qty")
    private BigDecimal carQty;
    @Column(name = "cstore_amt")
    private BigDecimal cstoreAmt;
    @Column(name = "cstore_qty")
    private BigDecimal cstoreQty;


    @Column(name = "cash_mogas_91_amt")
    private BigDecimal cashMogas91Amt;
    @Column(name = "cash_mogas_91_qty")
    private BigDecimal cashMogas91Qty;
    @Column(name = "cash_mogas_95_amt")
    private BigDecimal cashMogas95Amt ;
    @Column(name = "cash_mogas_95_qty")
    private BigDecimal cashMogas95Qty;
    @Column(name = "cash_diesel_go_amt")
    private BigDecimal cashDieselGoAmt;
    @Column(name = "cash_diesel_go_qty")
    private BigDecimal cashDieselGoQty;
    @Column(name = "cash_lube_amt")
    private BigDecimal cashLubeAmt;
    @Column(name = "cash_lube_qty")
    private BigDecimal cashLubeQty;
    @Column(name = "cash_car_amt")
    private BigDecimal cashCarAmt;
    @Column(name = "cash_car_qty")
    private BigDecimal cashCarQty;
    @Column(name = "cash_cstore_amt")
    private BigDecimal cashCstoreAmt;
    @Column(name = "cash_cstore_qty")
    private BigDecimal cashCstoreQty;



}