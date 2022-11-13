package com.app.service;

import com.app.dto.Login;
import com.app.model.Admin;
import com.app.model.Customer;

public interface LoginService {

	public Admin loginAdmin(Login admin);
	public Customer loginCustomer(Login customer);
	
}
