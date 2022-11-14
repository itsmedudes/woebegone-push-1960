package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CustomerException;
import com.app.model.Customer;
import com.app.services.CustomerSignupService;

@RestController
public class CustomerSignupController {
	
	@Autowired
	private  CustomerSignupService cs;
	
	@PostMapping("/user/signup")
	public Customer CreateAdmin(@RequestBody Customer customer) {
		 
		return cs.SignupCustomer(customer);
		
	}
	
	@PostMapping("/user/update")
	public Customer UpdateAdmin(@RequestBody Customer customer,@RequestParam String key) throws CustomerException {
		
		return cs.UpdateCustomer(customer, key);
	}
}
