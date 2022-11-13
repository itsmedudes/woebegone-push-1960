package com.app.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.CustomerDTO;
import com.app.exception.CustomerException;
import com.app.exception.TripBookingException;
import com.app.model.CompletedTrips;
import com.app.model.Customer;
import com.app.model.Driver;
import com.app.model.TripBooking;



public interface CustomerService {

	public Customer register(Customer customer) throws CustomerException;
	
	public List<Customer> getCustomer() throws CustomerException;
    
	public Customer deleteCustomer(int customerId) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer findCustomer(int customerId);
	
	public Customer validateCustomer(String username, String password);
	
	
	
	
	
}
