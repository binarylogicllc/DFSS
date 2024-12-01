package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CARD_WHITELIST")
@Data
@EqualsAndHashCode(callSuper=false)
public class CardWhitelist extends EntityAudit{
    
    @Id
    @Column(name = "CARD_UID")
    private String cardUid;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "CARD_PRODUCT_TYPE")
    @Enumerated(EnumType.STRING)
    private CardProductType cardProductType;

    @Type(type = "yes_no")
    @Column(name = "promotion_card")
    private Boolean isPromotionCard;

    @Column(name = "opening_balance")
    private BigDecimal openingBalance;

    @Column(name = "activation_fee")
    private BigDecimal activationFee;

    @Type(type = "yes_no")
    @Column(name = "allowed_activation")
    private Boolean allowedActivation;
}
