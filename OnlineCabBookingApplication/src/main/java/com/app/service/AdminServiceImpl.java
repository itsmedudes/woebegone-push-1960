package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.app.exception.AdminException;
import com.app.model.Admin;

public class AdminServiceImpl implements AdminService{

	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

}
