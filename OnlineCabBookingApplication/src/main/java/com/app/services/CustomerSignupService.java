package com.app.services;

import com.app.exception.CustomerException;
import com.app.model.Customer;

public interface CustomerSignupService {
	
	public Customer SignupCustomer(Customer customer);
	 
	public Customer UpdateCustomer(Customer customer,String key) throws CustomerException;
	
}
