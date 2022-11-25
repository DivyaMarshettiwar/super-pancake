package com.abm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.abm.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Query("select count(c) from Customer c where c.email = ?1")
	public long findByEmail(String email);
}
