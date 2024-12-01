package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "customer_corporate_settings")
@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerCorporateSettings extends EntityAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_corporate_seq")
    @SequenceGenerator(
            name = "customer_corporate_seq",
            sequenceName = "customer_corporate_settings_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name =  "customer_id")
    private Long customerId;

    @Column(name =  "customer_code")
    private String customerCode;

    @Type(type = "yes_no")
    @Column(name =  "label_required")
    private Boolean labelRequired;

    @Column(name =  "card_monthly_charging")
    private String cardMonthlyCharging;

    @Column(name = "holding_charges")
    private BigDecimal holdingCharges;

    @Column(name = "service_charging")
    private String serviceCharging;

    @Column(name = "service_fee")
    private BigDecimal serviceFee;

    @Column(name = "card_charging")
    private String cardCharging;

    @Column(name = "printing_charges")
    private BigDecimal printingCharges;

    @Type(type = "yes_no")
    @Column(name = "web_upload")
    private Boolean webUpload;

    @Type(type = "yes_no")
    @Column(name = "soft_copy_invoice_required")
    private Boolean softCopyInvoiceRequired;

    @Column(name = "soft_copy_invoice_emailids")
    private String softCopyInvoiceEmailIds;

    @Type(type = "yes_no")
    @Column(name = "requires_invoice_hard_copy")
    private Boolean requiresInvoiceHardCopy;

    @Type(type = "yes_no")
    @Column(name = "salalah_fc_invoice_required")
    private Boolean salalahFcInvoiceRequired;
}
