package com.app.repository;

import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.TripBooking;
@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking,Integer>{
	
}
