package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.CardProductType;
import com.ca.scheduler.core.domain.values.CardType;
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

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "ACTIVATED_STATION_ID")
    private String activatedStationId;

    @Column(name = "ACTIVATED_TIME")
    private LocalDateTime activatedTime;

    @Column(name = "EXPIRY_DATE")
    private LocalDateTime expiryDate;

}
