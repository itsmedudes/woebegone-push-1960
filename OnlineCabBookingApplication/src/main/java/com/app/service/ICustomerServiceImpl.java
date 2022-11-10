package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;

public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository cRepo;
	
	@Override
	public Customer insertCustomer(Customer customer) {
		
		Customer insertcustomer = cRepo.save(customer);
		
		return insertcustomer;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		Customer insertcustomer = cRepo.save(customer);
		
		return insertcustomer;
		
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		
		Customer cust = null;
		
		Optional<Customer> opt = cRepo.findById(customerId);
		if(opt.isPresent()) {
			
		 cust= 	opt.get();
			cRepo.delete(cust);
		}
		return cust;
	}

	@Override
	public List<Customer> viewCustomers() {
		
		List<Customer> list = null;
		list = cRepo.findAll();
		return list;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		
		Customer cust = null;
		
	Optional<Customer> opt = cRepo.findById(customerId);
		if(opt.isPresent()) {
			cust = opt.get();
		
		}
		return cust;
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		
		
		
		
		
		return null;
	}

}
