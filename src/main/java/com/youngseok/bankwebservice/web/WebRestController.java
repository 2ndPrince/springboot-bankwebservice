package com.youngseok.bankwebservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youngseok.bankwebservice.domain.account.Account;
import com.youngseok.bankwebservice.domain.account.AccountRepository;
import com.youngseok.bankwebservice.domain.customer.Customer;
import com.youngseok.bankwebservice.domain.customer.CustomerRepository;
import com.youngseok.bankwebservice.dto.account.AccountRequestDto;
import com.youngseok.bankwebservice.dto.customer.CustomerSaveRequestDto;

@RestController
public class WebRestController {
	
	private CustomerRepository customerRepository;
	private AccountRepository accountRepository;
	
	public WebRestController(CustomerRepository customerRepository, AccountRepository accountRepository) {
		this.customerRepository = customerRepository;
		this.accountRepository = accountRepository;
	}

	@GetMapping("/")
	public String home() {
		return "welcome Home";
	}
	
	// ---
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody CustomerSaveRequestDto dto){
		return customerRepository.save(dto.toEntity());
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) throws Exception{
		return customerRepository.findById(id)
				.orElseThrow(() -> new Exception("ABC"));
	}
	
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@RequestBody CustomerSaveRequestDto dto, @PathVariable Long id) {
		return customerRepository.findById(id).map(customer -> {
			return customer;
		})
		.orElseGet(() -> {
			return customerRepository.save(dto.toEntity());
		});
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}
	
	// ---
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	@PostMapping("/accounts")
	public Account createAccount(@RequestBody AccountRequestDto dto){
		return accountRepository.save(dto.toEntity());
	}
	
	@GetMapping("/accounts/{id}")
	public Account getAccount(@PathVariable Long id) throws Exception{
		return accountRepository.findById(id)
				.orElseThrow(() -> new Exception("Account not found"));
	}
	
	@PutMapping("/accounts/{id}")
	public Account updateAccount(@RequestBody AccountRequestDto dto, @PathVariable Long id) {
		return accountRepository.findById(id).map(account -> {
			return account;
		})
		.orElseGet(() -> {
			return accountRepository.save(dto.toEntity());
		});
	}
	
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable Long id) {
		accountRepository.deleteById(id);
	}
	
}
