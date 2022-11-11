package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.AdminException;
import com.app.model.Admin;
import com.app.model.TripBooking;
import com.app.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/insertadmin")
	public ResponseEntity<Admin> insertAdminHandler(@RequestBody Admin admin) throws AdminException {
		Admin savedAdmin = adminService.insertAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
	}
	
	@PutMapping("/updateadmin")
	public ResponseEntity<String> updateAdminHandler(@RequestBody Admin admin) throws AdminException {
		Admin updatedAdmin = adminService.updateAdmin(admin);
		return new ResponseEntity<String>("admin updated "+updatedAdmin,HttpStatus.ACCEPTED); 

	}
	
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<Admin> deleteMappingHandler(@PathVariable("adminId") Integer adminId) throws AdminException {
		Admin deleteAdmin = adminService.deleteAdmin(adminId);
		return new ResponseEntity<Admin>(deleteAdmin,HttpStatus.OK);
	}
	
	@GetMapping("/getalltrips/{customerId}")
	public ResponseEntity<List<TripBooking>>  getAllTripsHandler(@PathVariable("customerId") Integer customerId) throws AdminException{
		List<TripBooking> trips= adminService.getAllTrips(customerId);
		return new ResponseEntity<List<TripBooking>>(trips,HttpStatus.OK);
	}
	
	@GetMapping("/trips/cabwise")
	public ResponseEntity<List<TripBooking>> getTripsCabwiseHandler(){
		List<TripBooking> cabwisetrips= adminService.getTripsCabwise();
		return new ResponseEntity<List<TripBooking>>(cabwisetrips,HttpStatus.OK);
	}
	
	@GetMapping("/customerwisetrips")
	public List<TripBooking> getTripsCustomerwiseHandler(){
		List<TripBooking> customerwiselist = adminService.getTripsCustomerwise();
		return customerwiselist;
	}
	
	@GetMapping("/datewisetrips")
	public List<TripBooking> getTripsDatewiseHandler() throws AdminException{
		List<TripBooking> datewiselist = adminService.getTripsDatewise();
		return datewiselist;
	}
	
	@GetMapping("trips/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getTripsDatewiseAndCustomerHandler(@PathVariable("customerId") Integer customerId, @PathVariable("fromDate") String fromDate,@PathVariable("toDate") String toDate) throws AdminException{
		LocalDate fromDate1 = LocalDate.parse(fromDate);
		LocalDate toDate1 = LocalDate.parse(toDate);
		List<TripBooking> list = adminService.getAllTripsForDays(customerId, fromDate1, toDate1);
		return list;

	}
	
}
