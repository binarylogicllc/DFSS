package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CARD")
@Data
@EqualsAndHashCode(callSuper=false)
public class Card extends DomainBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
    @SequenceGenerator(
            name = "card_seq",
            sequenceName = "card_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "CARD_NO")
    private String cardNo;

    @Column(name = "CARD_UID")
    private String cardUid;

    @Column(name = "CARD_TOKEN")
    private String cardToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private CardType cardType;

    @Column(name = "CARD_PRODUCT")
    @Enumerated(EnumType.STRING)
    private CardProductType cardProduct;

    @Column(name = "ACCOUNT_NUMBER")
    private String account;

    @Column(name = "CUSTOMER_ID")
    private Long customer;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;

    @Type(type = "yes_no")
    @Column(name = "suspended")
    private Boolean suspended;

    @Type(type = "yes_no")
    @Column(name = "damaged")
    private Boolean damaged;

    @Type(type = "yes_no")
    @Column(name = "deleted")
    private Boolean deleted;

    @Type(type = "yes_no")
    @Column(name = "lost")
    private Boolean lost;

    @Type(type = "yes_no")
    @Column(name = "stolen")
    private Boolean stolen;

    @Column(name = "state")
    private Integer state;

    @Type(type = "yes_no")
    @Column(name = "reset_pin")
    private Boolean resetPin;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "fleet_no")
    private String fleetNo;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "card_group")
    private String cardGroup;

    @Column(name = "other_label")
    private String otherLabel;

    @Column(name = "start_date",columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @Column(name = "end_date",columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    @Column(name = "ACTIVATED_STATION_ID")
    private String activatedStationId;

    @Column(name = "ACTIVATED_TIME",columnDefinition = "TIMESTAMP")
    private LocalDateTime activatedTime;

    @Column(name = "EXPIRY_DATE",columnDefinition = "TIMESTAMP")
    private LocalDateTime expiryDate;

    @Column(name = "CARD_STATUS")
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name = "PIN")
    private String pin;

    @Column(name = "reason")
    private String reason;

    @Column(name = "nick_name")
    private String nickName;

    @Type(type = "yes_no")
    @Column(name = "default_card")
    private Boolean defaultCard;

    @Type(type = "yes_no")
    @Column(name = "qr_temp_card")
    private Boolean qrTempCard;

    @Type(type = "yes_no")
    @Column(name = "promotion_card")
    private Boolean isPromotionCard;

}
