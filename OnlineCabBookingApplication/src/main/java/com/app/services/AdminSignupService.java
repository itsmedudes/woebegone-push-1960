package com.app.services;

import com.app.exception.AdminException;
import com.app.model.Admin;

public interface AdminSignupService {
	
	public Admin signupAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin,String key) throws AdminException;
	
}