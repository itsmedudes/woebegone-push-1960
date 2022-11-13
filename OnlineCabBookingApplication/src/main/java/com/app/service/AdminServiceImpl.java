package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AdminDTO;
import com.app.exception.AdminException;
import com.app.exception.CustomerException;
import com.app.exception.DriverException;
import com.app.exception.UsernameNotFoundException;
import com.app.model.AbstractUser;
import com.app.model.Admin;
import com.app.model.AdminSession;
import com.app.model.Customer;
import com.app.model.Driver;
import com.app.model.TripBooking;
import com.app.repository.AdminRepository;
import com.app.repository.AdminSessionRepository;
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
	AdminSessionRepository adminSessionRepository;
	
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
	public Admin updatePassword(AdminDTO dto, String username, String key) throws AdminException, LoginException{
		Optional<AdminSession> otp = adminSessionRepository.findByUuid(key);
		Admin updated = null;
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");
		Optional<Admin> opt = adminRepository.findByUserUsername(username);
		if (opt.isEmpty())
			throw new UsernameNotFoundException("Username not found");
		else {
			Admin toUpdate = opt.get();
			Integer id = toUpdate.getAdminId();
			AbstractUser user = toUpdate.getUser();
			user.setPassword(dto.getPassword());
			Admin newOne = new Admin(id, user);
			updated = adminRepository.save(newOne);
		}
		return updated;
	}

	@Override
	public String logOutAdmin(String key) throws LoginException {
		Optional<AdminSession> otp = adminSessionRepository.findByUuid(key);
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");

		adminSessionRepository.delete(otp.get());
		return "Admin has succefully logged out.";
	}

	@Override
	public List<CompletedTrips> getTripsByCustomerId(Integer customerId, String key) {
		Optional<AdminSession> otp = adminSessionRepository.findByUuid(key);
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");

		List<CompletedTrips> listOfTrips = completedTripsDao.findByCustomerId(customerId);
		if (listOfTrips.isEmpty())
			throw new CustomerException("No trips Found by this Customer id " + customerId);
		return listOfTrips;
	}

	@Override
	public List<CompletedTrips> getAllTrips(String key) {
		Optional<AdminSession> otp = adminSessionRepository.findByUuid(key);
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");

		List<CompletedTrips> listOfTrips = completedTripsDao.findAll();
		if (listOfTrips.isEmpty())
			throw new CustomerException("No trips Found Currently.");
		return listOfTrips;
	}

	@Override
	public List<Driver> getListOfDrivers(String key) throws DriverException, LoginException {
		Optional<AdminSession> otp = adminSessionRepository.findByUuid(key);
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");

		List<Driver> listOfDrivers = driverRepository.findAll();
		if (listOfDrivers.isEmpty())
			throw new DriverException("There are no Drivers present in the Database");
		return listOfDrivers;
	}

	@Override
	public List<Customer> getListOfCustomers(String key) throws LoginException, CustomerException {
		Optional<AdminSession> otp = adminSessionRepository.findByUuid(key);
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");

		List<Customer> listOfCustomers = customerRepository.findAll();
		if (listOfCustomers.isEmpty())
			throw new CustomerException("There are no Customers present in the Database");

		return listOfCustomers;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDate fromDate, LocalDate toDate)
			throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

}
