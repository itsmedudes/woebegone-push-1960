package com.app.services;

import java.time.LocalDateTime;
import java.util.List;

import com.app.exception.AdminException;
import com.app.model.Admin;
import com.app.model.TripBooking;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException;
	
	public Admin deleteAdmin(Integer adminId) throws AdminException;
	
	public List<TripBooking> getAllTrips() throws AdminException;

	public List<TripBooking> getTripsDriverwise(Integer id) throws AdminException;
	
	public List<TripBooking> getTripsCustomerWise(Integer customerId) throws AdminException;
	
	public List<TripBooking> getTripsDateWise() throws AdminException;
	
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)throws AdminException;
}















