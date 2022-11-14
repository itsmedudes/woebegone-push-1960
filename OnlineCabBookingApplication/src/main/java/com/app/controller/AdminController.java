package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.AdminException;
import com.app.exception.CustomerException;
import com.app.model.Admin;
import com.app.model.TripBooking;
import com.app.services.AdminService;
import com.app.services.CabService;
import com.app.services.DriverService;
import com.app.services.TripBookingService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CabService cabService;
	
	@Autowired
	private DriverService driverServices;
	
	@Autowired
	private TripBookingService tbService;
		
		@PostMapping("/regadmin")
		public ResponseEntity<Admin> regAdminHandler (@Valid @RequestBody Admin a1) throws AdminException{
			Admin admin= adminService.insertAdmin(a1);
			 return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
		}
		
		@PutMapping("/updateadmin")
		public ResponseEntity<Admin> updateAdminHandler(@Valid @RequestBody Admin a1) throws AdminException{
			Admin updateadmin = adminService.updateAdmin(a1);
			
			return new ResponseEntity <Admin>(updateadmin,HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteadmin/{id}")
		public ResponseEntity<Admin> deleteAdminByIdHandler( @PathVariable Integer id) throws AdminException{
			Admin deleteadmin = adminService.deleteAdmin(id);
			
			return new ResponseEntity <Admin>(deleteadmin,HttpStatus.OK);
		}
		
		

		@GetMapping("/viewalltrips")
		public ResponseEntity<List<TripBooking>> getAllTripsHandler() throws AdminException{
			List<TripBooking> trips = adminService.getAllTrips();
			
			return new ResponseEntity<List<TripBooking>>(trips,HttpStatus.OK);
		}
		
		@GetMapping("/gettripsdriverwise/{id}")
		public ResponseEntity<List<TripBooking>> getCustByIdHandler(@PathVariable Integer id) throws AdminException{
			List<TripBooking> trips = adminService.getTripsDriverwise(id);
			
		   return new ResponseEntity<List<TripBooking>>(trips,HttpStatus.OK);
		}

}
