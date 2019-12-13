package com.youngseok.bankwebservice.dto.account;

import com.youngseok.bankwebservice.domain.account.Account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountRequestDto {
	
	private Long customerID;
	private String accountType;
	private Long accountBalance;
	private String accountMessage;
	private Boolean isActivated;
	
	public Account toEntity() {
		return Account.builder()
				.customerID(customerID)
				.accountType(accountType)
				.accountBalance(accountBalance)
				.accountMessage(accountMessage)
				.isActivated(isActivated)
				.build();
	}
}
