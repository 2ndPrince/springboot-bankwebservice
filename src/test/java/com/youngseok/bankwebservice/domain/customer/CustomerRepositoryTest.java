package com.youngseok.bankwebservice.domain.customer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void test() {
		//given
		customerRepository.save(Customer.builder()
				.customerName("Youngseok")
				.build());
		
		//when
		List<Customer> cusList = customerRepository.findAll();
		
		//then
		Customer cus = cusList.get(0);
		assertThat(cus.getCustomerName(), is("Youngsok"));
	}

}
