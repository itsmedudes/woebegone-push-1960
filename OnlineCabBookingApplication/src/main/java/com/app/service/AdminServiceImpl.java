package com.app.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.AdminException;
import com.app.model.Admin;
import com.app.model.Customer;
import com.app.model.TripBooking;
import com.app.repository.AdminRepository;
import com.app.repository.CabRepository;
import com.app.repository.CustomerRepository;
import com.app.repository.DriverRepository;
import com.app.repository.TripBookingRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private DriverRepository driverRepository;
	
	@Autowired
	private CabRepository cabRepository;
	
	@Autowired
	private TripBookingRepository tripRepository;
	
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
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent()) {
			List<TripBooking> trips = tripRepository.findAll();
			return trips;
		}
		throw new AdminException("Unable to find customer with id :- "+customerId+"!!!! please try again");
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		List<TripBooking> triplist = tripRepository.findByCabWise();
		if(triplist.size() > 0)
			return triplist;
		else
			throw new AdminException("Not Found...!!!!Please try again");
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		List<TripBooking> customertriplist = tripRepository.findByCustomerWise();
		if(customertriplist.size() > 0)
			return customertriplist;
		else
			throw new AdminException("Not Found...!!!!Please try again");
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminException {
		List<TripBooking> datetriplist = tripRepository.findByDateWise();
		if(datetriplist.size() > 0)
			return datetriplist;
		else
			throw new AdminException("Not Found...!!!!Please try again");
	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)throws AdminException {
		List<TripBooking> daytriplist = tripRepository.findByCustomerIdAndTime(customerId, fromDate,toDate);
		if(daytriplist.size() > 0)
			return daytriplist;
		else
			throw new AdminException("No trips found for customer id "+customerId+" from date : "+fromDate+" to date : "+toDate);
	}

}
