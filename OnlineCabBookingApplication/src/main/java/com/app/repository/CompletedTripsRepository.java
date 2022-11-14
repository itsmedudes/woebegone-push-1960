package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.CompletedTrips;

public interface CompletedTripsRepository extends JpaRepository<CompletedTrips, Integer> {

	 public List<CompletedTrips> findByCustomerId(Integer customerId); 
}
