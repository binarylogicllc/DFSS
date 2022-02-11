package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.OrderType;
import com.ca.scheduler.core.domain.values.PaymentMethod;
import com.ca.scheduler.core.domain.values.TransactionStatus;
import com.ca.scheduler.core.domain.values.TransactionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION")
@Data
@EqualsAndHashCode(callSuper=false)
public class Transaction extends EntityAudit implements ITransaction {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(
            name = "transaction_seq",
            sequenceName = "transaction_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRX_TYPE")
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_TYPE")
    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_METHOD")
    private PaymentMethod paymentMethod;

    @Column(name = "REQUEST_LITER")
    private  BigDecimal requestLiter;

    @Column(name = "APPROVED_LITER")
    private  BigDecimal approvedLiter;

    @Column(name = "BALANCE_LITER")
    private  BigDecimal balanceLiter;

    @Column(name = "qrcode_ref")
    private String qrCode;

    @Column(name = "CARD_NO")
    private String card;

    @Column(name = "account_number")
    private String account;

    @Column(name = "CUSTOMER_ID")
    private Long customer;

    @Column(name = "TRX_REF")
    private String transactionRef;

    @Column(name = "APPROVAL_CODE")
    private String approvalCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private TransactionStatus status;

    @Column(name = "INVOICE_NO")
    private String invoiceNo;

    @Column(name = "SHIFT_NO")
    private String shiftNo;

    @Column(name = "ATTENDANT_ID")
    private String attendantId;

    @Column(name = "BATCH_NO")
    private String batchNo;

    @Column(name = "POS_ID")
    private String posId;

    @Column(name = "STATION_ID")
    private String stationId;

    @Column(name = "PUMP_ID")
    private String pumpId;

    @Column(name = "ODOMETER")
    private String Odometer;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    @Column(name = "BASE_AMOUNT")
    private BigDecimal baseAmount;

    @Column(name = "DISCOUNT_AMOUNT")
    private BigDecimal discountAmount;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "fuel_product")
    private String fuelProduct;

    @Column(name = "subsidy_product")
    private String subsidyProduct;

    @Column(name = "TRANSACTION_DATE", columnDefinition = "timestamp with time zone")
    private LocalDateTime transactionDate;

    @Column(name = "AUTHORIZE_DATE", columnDefinition = "timestamp with time zone")
    private LocalDateTime authorizeDate;

    @Column(name = "COMPLETE_DATE", columnDefinition = "timestamp with time zone")
    private LocalDateTime completeDate;

    @Column(name = "VOID_DATE", columnDefinition = "timestamp with time zone")
    private LocalDateTime voidDate;

    @Column(name = "SETTLEMENT_DATE", columnDefinition = "timestamp with time zone")
    private LocalDateTime settlementDate;

}
