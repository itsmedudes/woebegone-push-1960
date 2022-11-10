package com.app.service;

import java.util.List;

import com.app.exception.TripBookingException;
import com.app.model.TripBooking;

public interface TripBookingService {
	public TripBooking insertBookingTrip(TripBooking tripBooking) throws TripBookingException;
	public TripBooking updateTripBooking(TripBooking tripBooking)throws TripBookingException;
	public TripBooking deleteTripBooking(Integer tripBookingId)throws TripBookingException;
	public List<TripBooking> ViewAllTrips(Integer customerId)throws TripBookingException;
	public TripBooking calculateBill(Integer customerId)throws TripBookingException;
	
	
}
