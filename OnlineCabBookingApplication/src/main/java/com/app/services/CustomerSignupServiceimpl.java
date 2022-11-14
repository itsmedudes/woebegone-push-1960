package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CustomerException;
import com.app.model.CurrentUserSession;
import com.app.model.Customer;
import com.app.repository.CurrentUserSessiondDao;
import com.app.repository.CustomerDao;

@Service
public class CustomerSignupServiceimpl implements CustomerSignupService{

	
	@Autowired
	private CustomerDao adao;
	
	@Autowired
	private CurrentUserSessiondDao cusd;
	
	@Override
	public Customer SignupCustomer(Customer customer) {
		
		Customer Customer1=adao.save(customer);
		return Customer1;
	}

	@Override
	public Customer UpdateCustomer(Customer customer, String key) throws CustomerException {
		CurrentUserSession cu=	cusd.findByuuid(key).orElseThrow(()-> new CustomerException("User Not Logged in"));
		
		if(customer.getCustomerId()==cu.getUserId()) {
			return adao.save(customer);
		}
		else
			throw new CustomerException("Please Enter a correct Customer id");
		
		}
	}
