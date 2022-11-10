package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.TripBookingException;
import com.app.model.TripBooking;
import com.app.repository.CustomerRepository;
import com.app.repository.TripBookingRepository;
@Service
public class TripBookingServiceImpl implements TripBookingService {
	
	@Autowired
	private TripBookingRepository tbRepo;
	
	@Autowired 
	private CustomerRepository customer;
	

	@Override
	public TripBooking insertBookingTrip(TripBooking tripBooking) throws TripBookingException {
		if(tripBooking!=null) {
			return tbRepo.save(tripBooking);
		}
		else throw new TripBookingException(" no Seat available");
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException {
		
         Optional<TripBooking> Id= tbRepo.findById(tripBooking.getTripBookingId());
         if(Id.isPresent())
         {
        	return tbRepo.save(tripBooking);
         }
         else
         {
        	throw new TripBookingException("You didnt have book ticket Yet"); 
         }
	}

	@Override
	public TripBooking deleteTripBooking(Integer tripBookingId) throws TripBookingException {
	       Optional<TripBooking> Id= tbRepo.findById(tripBookingId);
	       if(Id.isPresent())
	         {
	    	   TripBooking Tb= Id.get();
	        	tbRepo.delete(Tb);
	        	return Tb;
	         }
	         else
	         {
	        	throw new TripBookingException("You didnt have book ticket Yet"); 
	         }
	       
	}

	@Override
	public List<TripBooking> ViewAllTrips(Integer customerId) throws TripBookingException {
		return null;
		
	}

	@Override
	public TripBooking calculateBill(Integer customerId) throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
