package com.youngseok.bankwebservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youngseok.bankwebservice.domain.customer.CustomerRepository;
import com.youngseok.bankwebservice.dto.customer.CustomerSaveRequestDto;

@RestController
public class WebRestController {
	
	private CustomerRepository customerRepository;
	
	public WebRestController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("")
	public String home() {
		return "welcome home";
	}
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "hello, " + name;
	}
	
	@PostMapping("/customer")
	public void saveCustomer(@RequestBody CustomerSaveRequestDto dto){
		customerRepository.save(dto.toEntity());
	}
}
