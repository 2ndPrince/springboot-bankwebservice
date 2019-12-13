package com.youngseok.bankwebservice.domain.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerID;
	
	@Column(length = 500, nullable = false)
	private String customerName;
	
	private Long customerSSN;
	private Long customerAge;
	private String customerAddress;
	private String customerCity;
	private String customerState;
	
	@Column(columnDefinition = "TEXT")
	private String customerMessage;
	
	private Boolean isActivated;
	
	@Builder
	public Customer(String customerName, Long customerSSN, Long customerAge, String customerAddress,
			String customerCity, String customerState, String customerMessage, Boolean isActivated) {
		this.customerName = customerName;
		this.customerSSN = customerSSN;
		this.customerAge = customerAge;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerState = customerState;
		this.customerMessage = customerMessage;
		this.isActivated = isActivated;
	}
	
	
}

	
