package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.exception.CustomerException;
import com.app.model.Customer;
import com.app.repository.CompletedTripsRepository;
import com.app.repository.CustomerRepository;
import com.app.repository.DriverRepository;
import com.app.repository.TripBookingRepository;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository cRepo;


	@Override
	public Customer register(Customer customer) {

		Customer cust = cRepo.save(customer);
		return cust;


	}

	@Override
	public List<Customer> getCustomer() throws CustomerException {
		
		List<Customer> list = cRepo.findAll();

		return list;
		
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerException {
		
	Optional<Customer> opt =cRepo.findById(customerId);
		
		if(opt.isPresent()) {
			Customer cust = opt.get();
			return cust;
		}
		else throw new CustomerException("The customer with this id does not exist");
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		
Optional<Customer> opt =cRepo.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			Customer cust = opt.get();
			return cust;
		}
		else throw new CustomerException("The customer with this id does not exist");
		
		
	}

	@Override
	public Customer findCustomer(int customerId) {
		
		Optional<Customer> opt =cRepo.findById(customerId);
		if(opt.isPresent()) {
			Customer cust = opt.get();
			return cust;
		}
		
		return null;
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		
		Optional<Customer> opt = cRepo.findByUserMobile(password);
		Customer cust = null;
		
		if(opt.isPresent()) {
			 cust = opt.get();
			return cust;
		}
		return cust;
	}

}
