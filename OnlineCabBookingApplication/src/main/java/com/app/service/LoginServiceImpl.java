package com.app.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.AdminDTO;
import com.app.dto.Login;
import com.app.model.Admin;
import com.app.model.Customer;
import com.app.model.Driver;
import com.app.repository.AdminRepository;
import com.app.repository.CustomerRepository;
import com.app.repository.DriverRepository;


public class LoginServiceImpl  implements LoginService{

	@Autowired
	private AdminRepository aRepo;

	@Autowired
	private CustomerRepository cRepo;

	@Autowired
	private AdminRepository adRepo;

	@Autowired
	private Driver driver;

	@Autowired
	private DriverRepository dRepo;

	@Override
	public Customer loginCustomer(Login customer) {

		Optional<Customer> res = ((CustomerRepository) customer).findByUserMobile(customer.getUsername());

		if (!res.isPresent()) {
			System.out.println(res + " Data is empty");
			throw new CustomerException("Customer does not exist with the given mobile number");
		}

		Customer existingCustomer = res.get();
		Optional<UserSession> opt = sessionDAO.findByUserId(existingCustomer.getCustomerId());

		if (opt.isPresent())
			throw new LoginException("User already logged in");

		if (existingCustomer.getUser().getPassword().equals(customer.getPassword())) {

			UserSession newSession = new UserSession();

			newSession.setUserId(existingCustomer.getCustomerId());
			newSession.setUserType("Customer");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return sessionDAO.save(newSession);
		} else {
			throw new LoginException("Password Incorrect. Try again.");
		}

	}

	@Override
	public AdminSession loginAdmin(LoginDTO dto) {
		Optional<Admin> res = adminDao.findByUserMobile(dto.getMobile());

		if (res.isEmpty()) {
			System.out.println("No Admin exist");
			throw new CustomerException("Admin was not there in the data base");
		}

		Admin existingAdmin = res.get();
		Optional<AdminSession> opt = adminSession.findByAdminId(existingAdmin.getAdminId());

		if (opt.isPresent())
			throw new LoginException("User already logged in");

		if (existingAdmin.getUser().getPassword().equals(dto.getPassword())) {

			AdminSession newSession = new AdminSession();

			newSession.setAdminId(existingAdmin.getAdminId());
			newSession.setUserType("Customer");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return adminSession.save(newSession);
		} else {
			throw new LoginException("Password Incorrect. Try again.");
		}
	}

	@Override
	public DriverSession loginDriver(LoginDTO driver) {
		Optional<Driver> res = driverDAO.findByUserMobile(driver.getMobile());

		if (!res.isPresent()) {
			System.out.println(res + " Data is empty");
			throw new CustomerException("Driver does not exist with the given mobile number");
		}

		Driver existingDriver = res.get();
		Optional<DriverSession> opt = driverSessionDao.findByDriverId(existingDriver.getDriverId());

		if (opt.isPresent())
			throw new LoginException("User already logged in");

		if (existingDriver.getUser().getPassword().equals(driver.getPassword())) {

			DriverSession newSession = new DriverSession();

			newSession.setDriverId(existingDriver.getDriverId());
			newSession.setUserType("Driver");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return driverSessionDao.save(newSession);
		} else {
			throw new LoginException("Password Incorrect. Try again.");
		}
	}

	@Override
	public Admin loginAdmin(Login admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer loginCustomer(Login customer) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
