package com.abm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.abm.entity.Customer;
import com.abm.repository.CustomerRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringBootAppApplicationTests {
	
	@Autowired
	private CustomerRepository custRepo;

	@Test
	void addCustomer() {
		Customer cust = new Customer();
		cust.setName("Divya");
		cust.setEmail("divya@gmail.com");
		cust.setPassword("abcd1234");
		cust.setMobileNumber("1234567891");
		custRepo.save(cust);
		
	}

}
