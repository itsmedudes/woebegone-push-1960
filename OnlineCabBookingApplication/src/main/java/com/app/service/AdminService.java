package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.app.dto.AdminDTO;
import com.app.exception.AdminException;
import com.app.exception.CustomerException;
import com.app.exception.DriverException;
import com.app.model.Admin;
import com.app.model.Customer;
import com.app.model.Driver;
import com.app.model.TripBooking;

public interface AdminService {

	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException;
	
	public Admin deleteAdmin(Integer adminId) throws AdminException;
	
	public Admin updatePassword(AdminDTO dto, String username, String key) throws AdminException,LoginException;
	
	public String logOutAdmin(String key) throws LoginException;
	
	public List<CompletedTrips> getTripsByCustomerId(Integer customerId, String key);
	
	public List<CompletedTrips> getAllTrips(String key);
	
	public List<Driver> getListOfDrivers(String key) throws DriverException, LoginException;
	
	public List<Customer> getListOfCustomers(String key) throws LoginException, CustomerException;
	

}
