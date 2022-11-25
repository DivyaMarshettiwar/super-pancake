package com.abm.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.CustomerDetails;
import com.abm.dto.RegistrationStatus;
import com.abm.entity.Customer;
import com.abm.exception.CustomerServiceException;
import com.abm.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public RegistrationStatus register(CustomerDetails customerDetails) {
		try {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDetails, customer);
			customer.setPassword(Base64.getEncoder().encodeToString(customerDetails.getPassword1().getBytes()));
			
			try {
				String fileName = customerDetails.getProfilePic().getOriginalFilename();
				customer.setProfilePic(fileName);
				
				InputStream is = customerDetails.getProfilePic().getInputStream();
				FileOutputStream os = new FileOutputStream("/Volumes/Data/uploads/" + fileName);
				FileCopyUtils.copy(is, os);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			customerService.register(customer);
			
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setStatusMessage("Customer registered successfully!");
			status.setRegisteredCustomerId(customer.getId()); //complete this line
			return status;
			//return "Customer registered successfully!";
		}
		catch (CustomerServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
			//return e.getMessage();	
		}
	}
	
	/*@RequestMapping("/register")
	public RegistrationStatus register(@RequestBody CustomerDetails customerDetails) {
		try {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDetails, customer);
			customer.setPassword(Base64.getEncoder().encodeToString(customerDetails.getPassword1().getBytes()));
			
			customerService.register(customer);
			
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setStatusMessage("Customer registered successfully!");
			status.setRegisteredCustomerId(customer.getId()); //complete this line
			return status;
			//return "Customer registered successfully!";
		}
		catch (CustomerServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
			//return e.getMessage();	
		}
	}*/
	
	/*@RequestMapping("/register")
	public RegistrationStatus register(@RequestBody Customer customer) {
		try {
			customerService.register(customer);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setStatusMessage("Customer registered successfully!");
			status.setRegisteredCustomerId(customer.getId()); //complete this line
			return status;
			//return "Customer registered successfully!";
		}
		catch (CustomerServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
			//return e.getMessage();	
		}
	}*/
}