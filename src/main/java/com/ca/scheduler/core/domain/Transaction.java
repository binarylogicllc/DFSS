package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

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

    @Column(name = "CARD_UID")
    private String cardUID;

    @Column(name = "account_number")
    private String account;

    @Column(name = "CUSTOMER_ID")
    private Long customer;

    @Column(name = "CUSTOMER_CODE")
    private String customerCode;

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

    @Column(name = "STATION_NAME")
    private String stationName;

    @Column(name = "PUMP_ID")
    private String pumpId;

    @Column(name = "ODOMETER")
    private String odometer;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    @Column(name = "FEE_AMOUNT")
    private BigDecimal feeAmount;

    @Column(name = "BASE_AMOUNT")
    private BigDecimal baseAmount;

    @Column(name = "DISCOUNT_AMOUNT")
    private BigDecimal discountAmount;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "BALANCE_AMOUNT")
    private  BigDecimal balanceAmount;

    @Column(name = "fuel_product")
    private String fuelProduct;

    @Column(name = "subsidy_product")
    private String subsidyProduct;

    @Column(name = "TRACE_NO")
    private String traceNo;

    @Column(name = "civil_id")
    private String civilId;

    @Column(name = "req_id")
    private String reqId;

    @Column(name = "customer_name")
    private String customerName;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "CARD_PRODUCT")
    private CardProductType cardProduct;

    @Column(name = "LIMIT_ON")
    private String limitOn;

    @Column(name = "LIMIT_BALANCE")
    private  BigDecimal limitBalance;

    @Column(name = "LIMIT_TYPE")
    private String limitType;

    @Column(name = "CARD_EXPIRY")
    private String cardExpiry;

    @Column(name = "TXN_TOKEN")
    private String trxToken;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "vat_in")
    private String vatIN;

    @Column(name = "promo_code")
    private String promoCode;

    @Column(name = "promo_desc")
    private String promoDesc;

    @Column(name = "promo_title")
    private String promoTitle;

    @Column(name = "promo_expiry")
    private String promoExpiry;

    @Column(name = "points")
    private Integer points;

    @Column(name = "balance_points")
    private Integer balancePoints;

    @Column(name = "cust_vat_in")
    private String custVatIN;

    @Column(name = "to_account_number")
    private String toAccount;

    @Column(name = "to_card_no")
    private String toCardNo;

    @Column(name = "org_balance_amt")
    private  BigDecimal orgBalanceAmt;

    @Column(name = "bank_ref_no")
    private  String bankRefNo;

    @Column(name = "topup_auth_attendant_id")
    private String topupAuthAttendantId;

    @Type(type = "yes_no")
    @Column(name = "promotion_card")
    private Boolean isPromotionCard;

    @Column(name = "opening_balance")
    private BigDecimal openingBalance;

    @Column(name = "activation_fee")
    private BigDecimal activationFee;
}
