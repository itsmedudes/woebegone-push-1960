package com.app.services;

import com.app.exception.CustomerException;
import com.app.model.CustomerLogin;

public interface CustomerLoginService {
	
	public String Customerlogin(CustomerLogin al) throws CustomerException;
	
	public String Customerlogout(String key) throws CustomerException;
	
}
