<<<<<<< HEAD:OnlineCabBookingApplication/src/main/java/com/masai/services/CustomerService.java
package com.masai.services;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer insertCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public List<Customer> viewCustomer() throws CustomerException;
	
	public Customer viewCustomer(Integer customerId) throws CustomerException;
	
	public Customer validateCustomer(String username, String password) throws CustomerException;
    

=======
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
	
	
	
	
	
>>>>>>> 89557e95f1bba0dcc53819b504c94ef1b515f004:OnlineCabBookingApplication/src/main/java/com/app/service/CustomerService.java
}
