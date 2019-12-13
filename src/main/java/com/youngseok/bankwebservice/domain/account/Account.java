package com.youngseok.bankwebservice.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.youngseok.bankwebservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Account extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountID;
	
	@JoinColumn(referencedColumnName = "customerID")
	private Long customerID;
	
	private String accountType;
	
	private Long accountBalance;
	
	@Column(columnDefinition = "TEXT")
	private String accountMessage;
	
	private Boolean isActivated;

	@Builder
	public Account(Long customerID, String accountType, Long accountBalance, String accountMessage,
			Boolean isActivated) {
		this.customerID = customerID;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountMessage = accountMessage;
		this.isActivated = isActivated;
	}
	
	
}
