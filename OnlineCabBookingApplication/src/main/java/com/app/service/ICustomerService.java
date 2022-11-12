package com.app.service;

import java.util.List;

import com.app.exception.CustomerException;
import com.app.model.Customer;

public interface ICustomerService {

	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public Customer deleteCustomer(int customerId) throws CustomerException;
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	public Customer validateCustomer(String username, String password);
	
}
