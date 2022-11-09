package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;






public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository cRepo;
	
	
	
	@Override
	public Customer insertCustomer(Customer customer) {
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewCustomers() {
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
