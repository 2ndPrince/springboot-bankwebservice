package com.youngseok.bankwebservice.dto.customer;

import com.youngseok.bankwebservice.domain.customer.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerSaveRequestDto {

	private String customerName;
	private Long customerSSN;
	private Long customerAge;
	private String customerAddress;
	private String customerCity;
	private String customerState;
	private String customerMessage;
	private Boolean isActivated;
	
	public Customer toEntity() {
		return Customer.builder()
				.customerName(customerName)
				.customerSSN(customerSSN)
				.customerAge(customerAge)
				.customerAddress(customerAddress)
				.customerCity(customerCity)
				.customerState(customerState)
				.customerMessage(customerMessage)
				.isActivated(isActivated)
				.build();
	}
	
}
