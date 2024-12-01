package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendant_card")
@Data
@EqualsAndHashCode(callSuper=false)
public class AttendantCard extends DomainBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendant_card_seq")
    @SequenceGenerator(
            name = "attendant_card_seq",
            sequenceName = "attendant_card_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "card_uid")
    private String cardUid;

    @Column(name = "attendant_id")
    private Long attendantId;

    @Column(name = "ACTIVATED_STATION_ID")
    private String activatedStationId;

    @Column(name = "ACTIVATED_TIME",columnDefinition = "TIMESTAMP")
    private LocalDateTime activatedTime;

    @Column(name = "EXPIRY_DATE",columnDefinition = "TIMESTAMP")
    private LocalDateTime expiryDate;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "card_group")
    private String cardGroup;

    @Column(name = "other_label")
    private String otherLabel;

    @Column(name = "CARD_STATUS")
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name = "pin")
    private String pin;

    @Type(type = "yes_no")
    @Column(name = "reset_pin")
    private Boolean resetPin;

    @Type(type = "yes_no")
    @Column(name = "pin_required")
    private Boolean pinRequired;

    @Type(type = "yes_no")
    @Column(name = "active")
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

    @Type(type = "yes_no")
    @Column(name = "damaged")
    private Boolean damaged;
}
