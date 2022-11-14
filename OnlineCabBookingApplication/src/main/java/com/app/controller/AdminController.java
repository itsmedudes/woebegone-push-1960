package com.app.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdminDTO;
import com.app.dto.Login;
import com.app.exception.AdminException;
import com.app.exception.CustomerException;
import com.app.exception.DriverException;
import com.app.model.Admin;
import com.app.model.AdminSession;
import com.app.model.CompletedTrips;
import com.app.model.Customer;
import com.app.model.Driver;
import com.app.service.AdminService;
import com.app.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/insertadmin")
	public ResponseEntity<Admin> insertAdminHandler(@RequestBody Admin admin) throws AdminException {
		Admin savedAdmin = adminService.insertAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AdminSession> loginAdmin(@RequestBody Login dto) {
		return new ResponseEntity<>(loginService.loginAdmin(dto), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateadmin")
	public ResponseEntity<String> updateAdminHandler(@RequestBody Admin admin) throws AdminException {
		Admin updatedAdmin = adminService.updateAdmin(admin);
		return new ResponseEntity<String>("admin updated "+updatedAdmin,HttpStatus.ACCEPTED); 

	}
	
	@PatchMapping("/update/{username}")
	public Admin updateAdminPassword(@RequestBody AdminDTO dto, @PathVariable("username") String username,
			@RequestParam String key) throws LoginException, AdminException {
		return adminService.updatePassword(dto, username, key);
	}
	
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<Admin> deleteMappingHandler(@PathVariable("adminId") Integer adminId) throws AdminException {
		Admin deleteAdmin = adminService.deleteAdmin(adminId);
		return new ResponseEntity<Admin>(deleteAdmin,HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public String logoutAdmin(@RequestParam String key) {

		return adminService.logoutAdmin(key);

	}
	
	@GetMapping("/listoftripsbycustomer")
	public List<CompletedTrips> listOfAllTripsByCustomer(@RequestParam Integer customerId, @RequestParam String key) throws LoginException, CustomerException {
		return adminService.getTripsByCustomerId(customerId, key);

	}

	@GetMapping("/listoftrips")
	public List<CompletedTrips> listOfAllTrips(@RequestParam String key) throws LoginException, CustomerException {
		return adminService.getAllTrips(key);
	}

	@GetMapping("/listofcustomers")
	public List<Customer> listOfCustomers(@RequestParam String key) throws LoginException, CustomerException {

		List<Customer> listOfCustomers = adminService.getListOfCustomers(key);

		return listOfCustomers;
	}

	@GetMapping("/listofdrivers")
	public List<Driver> listOfDrivers(@RequestParam String key) throws LoginException, DriverException {

		List<Driver> listOfDrivers = adminService.getListOfDrivers(key);

		return listOfDrivers;
	}
	
	
	
}
