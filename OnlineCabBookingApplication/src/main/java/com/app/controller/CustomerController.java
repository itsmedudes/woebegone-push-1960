package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	private ICustomerService icService;
	
	
	
	
	
}
