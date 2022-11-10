package com.app.controller;

import java.util.List;

<<<<<<< HEAD
=======
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

import com.app.exception.DriverException;
import com.app.model.Driver;
import com.app.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/register")
	public ResponseEntity<Driver> registerDriverHandler(@Valid @RequestBody Driver driver) throws DriverException{
		Driver registerDriver = driverService.insertDriver(driver);
		return new ResponseEntity<Driver>(registerDriver,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Driver> updateDriverHandler(@Valid @RequestBody Driver driver) throws DriverException{
		Driver updateDriver = driverService.updateDriver(driver);
		return new ResponseEntity<Driver>(updateDriver,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{driverid}")
	public ResponseEntity<Driver> deleteDriverHandler(@PathVariable("driverid") Integer driverId) throws DriverException{
		Driver deleteDriver = driverService.deleteDriver(driverId);
		return new ResponseEntity<Driver>(deleteDriver,HttpStatus.OK);
	}
	
	@GetMapping("/rating")
	public ResponseEntity<List<Driver>> bestRatingDriverHandler() throws DriverException{
		List<Driver> bestRatingDriverList = driverService.viewBestDrivers();
		return new ResponseEntity<List<Driver>>(bestRatingDriverList,HttpStatus.OK);
		
	}
	
	@GetMapping("/driver/{driverid}")
	public ResponseEntity<Driver> viewDriveHandler(@PathVariable("driverid") Integer driverId) throws DriverException{
		Driver driver = driverService.viewDriver(driverId);
		return new ResponseEntity<Driver>(driver,HttpStatus.OK);
	}
	
>>>>>>> cef75c15bbf212ee7d00cdce66eb2ecb38ae910a
	
}
