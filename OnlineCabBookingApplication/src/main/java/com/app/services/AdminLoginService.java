package com.app.services;

import com.app.exception.AdminException;
import com.app.model.AdminLogin;

public interface AdminLoginService {
	
	public String Adminlogin(AdminLogin al) throws AdminException;
	
	public String Adminlogout(String key) throws AdminException;
	
}
