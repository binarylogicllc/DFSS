package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.AccountType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ACCOUNT")
@Data
@EqualsAndHashCode(callSuper=false)
public class Account extends EntityAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_id_seq", allocationSize = 1)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "ACCOUNT_NUMBER", unique = true, nullable = false)
	private String accountNumber;

	@Column(name = "ACTIVE")
	@Type(type = "yes_no")
	private Boolean active;

	@Column(name = "START_DATE")
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	private LocalDateTime endDate;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	@Column(name = "SUBSIDY_PRODUCT")
	private String subsidyProduct;

	@Column(name = "ACCOUNT_PRODUCT")
	@Enumerated(EnumType.STRING)
	private AccountType accountProduct;

	@Column(name = "CUSTOMER_ID")
	private Long customer;

}
