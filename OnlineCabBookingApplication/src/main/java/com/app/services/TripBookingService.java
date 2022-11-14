package com.app.services;

import java.util.List;

import com.app.exception.TripBookingException;
import com.app.model.TripBooking;

public interface TripBookingService {
	
	public TripBooking insertTripBooking(TripBooking tripBooking, Integer customerId) throws TripBookingException;
	
	
	
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException;
	
	public TripBooking deleteTripBooking(Integer tripBookingId) throws TripBookingException;
	
	public List<TripBooking> viewAllTripsCustomer(Integer customerId) throws TripBookingException;;
	
	public TripBooking calculateBill(Integer customerId, Integer tripId) throws TripBookingException;;
	
}
