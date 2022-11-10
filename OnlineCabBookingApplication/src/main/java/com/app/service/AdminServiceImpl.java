package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.AdminException;
import com.app.exception.DriverException;
import com.app.model.Admin;
import com.app.model.TripBooking;
import com.app.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
		if(admin != null) return adminRepository.save(admin);
		else throw new AdminException("Wrong Credentials !!!! Please Try Again");
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		Optional<Admin> adminUpdate = adminRepository.findById(admin.getAdminId());
		if (adminUpdate.isPresent()) {
			return adminRepository.save(admin);
		}
		throw new AdminException("Unable to find admin with id :- "+admin.getAdminId()+"!!!! please try again");
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		Admin existingAdmin = adminRepository.findById(adminId).orElseThrow(() -> new AdminException("Unable to find admin with id :- "+adminId+"!!!! please try again"));
		
		adminRepository.delete(existingAdmin);

		return existingAdmin;
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
