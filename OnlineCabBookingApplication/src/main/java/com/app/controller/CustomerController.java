package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CustomerException;
import com.app.model.Customer;
import com.app.model.ModelUser;
import com.app.service.CustomerService;
import com.app.service.LoginService;


@RestController
@RequestMapping("/customer")
public class CustomerController {


	@Autowired
	private CustomerService customerService;

	@Autowired
	private LoginService loginService;

	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer user) {
		Customer newUser = null;
		try {
			newUser = customerService.register(user);
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newUser;

	}

	@GetMapping("/customerlist")
	public List<Customer> getAllCustomer() {
		List<Customer> list = null;
		try {
			list = customerService.getCustomer();
			if (list.isEmpty()) {
				throw new CustomerException("List of customer not exist");
			}else {
				return list;
			}
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Integer customerId){
		
		
		
			Customer deletedCustomer = null;
			try {
				deletedCustomer = customerService.deleteCustomer(customerId);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<Customer>(deletedCustomer , HttpStatus.CREATED.OK);
		
	}
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Integer customerId){
		
			Customer getCustomer = null;
			getCustomer = customerService.findCustomer(customerId);
			return new ResponseEntity<Customer>(getCustomer , HttpStatus.CREATED.OK);
		
	}
	
	@PostMapping("/update")
	public Customer updateCustomer(@RequestBody Customer user) {
		Customer newUser = null;
		try {
			newUser = customerService.updateCustomer(user);
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newUser;

	}
	//left from here
	@GetMapping("/validate/{username}/{password}")
	public ResponseEntity<Customer> validateCustomer(@PathVariable("username") String username,
													 @PathVariable("password") String password){
		
			Customer getCustomer = null;
			getCustomer = customerService.validateCustomer(username, password);
			return new ResponseEntity<Customer>(getCustomer , HttpStatus.CREATED.OK);
		
	}
	
}
