package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.TripBookingException;
import com.app.model.TripBooking;
import com.app.service.TripBookingService;

@RestController
public class TripBookingController {
	
	@Autowired
	private TripBookingService tripBookingService;
	
	@PostMapping("/tripregister")
	public ResponseEntity<TripBooking> registerTripHandler(@Valid @RequestBody TripBooking tripbooking) throws TripBookingException{
		
		TripBooking registerTrip= tripBookingService.insertBookingTrip(tripbooking);
		return new ResponseEntity<TripBooking>(registerTrip,HttpStatus.CREATED);
		
		
	}
	@PutMapping("/updatetrip")
	public ResponseEntity<TripBooking> updateTripHandler(@Valid @RequestBody TripBooking tripbooking)throws TripBookingException{
		TripBooking updateTrip= tripBookingService.updateTripBooking(tripbooking);
		return new ResponseEntity<TripBooking>(updateTrip,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletetrip")
	public ResponseEntity<TripBooking> deleteTripHandler(@Valid @RequestBody Integer tripbooking) throws TripBookingException{
		TripBooking deleteTrip= tripBookingService.deleteTripBooking(tripbooking);
		return new ResponseEntity<TripBooking>(deleteTrip,HttpStatus.OK);
		
	}
		
	}
	
	


