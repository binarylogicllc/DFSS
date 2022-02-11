package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
