package com.app.controller;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.service.ICustomerService;


@RestController
@RequestMapping("/cabbookingapp")
public class CustomerController {

	@Autowired
	private ICustomerService icService;
	
	
	@PostMapping("cabbookingapp/customers")
	public ResponseEntity<String> registerCustomer(Customer customer){
		
		Customer savecustomer = icService.insertCustomer(customer);

		return new ResponseEntity<String>(customer.toString(), HttpStatus.CREATED);
	}
	
	@PostMapping("cabbookingapp/customers/update")
	public ResponseEntity<String> updateCustomer(Customer customer){
		
		Customer savecustomer = icService.updateCustomer(customer);

		return new ResponseEntity<String>(customer.toString(), HttpStatus.CREATED);
	}
	
	@DeleteMapping("cabbookingapp/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Integer customerId){
		
		
		
			Customer deletedcustomer = null;
			
			deletedcustomer = icService.deleteCustomer(customerId);
			
			return new ResponseEntity<Customer>(deletedcustomer , HttpStatus.CREATED.OK);
		
	}
	
	
	
	
	
	
	
	
}
