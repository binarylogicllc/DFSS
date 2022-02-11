package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TERMINAL_WHITELIST")
@Data
@EqualsAndHashCode(callSuper=false)
public class TerminalWhitelist extends EntityAudit{
    
    @Id
    @Column(name = "DEVICE_SERIAL")
    private String deviceSerial;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE")
    private Boolean active;
}
