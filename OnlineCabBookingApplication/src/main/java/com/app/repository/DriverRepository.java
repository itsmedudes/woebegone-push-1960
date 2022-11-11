package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
	public Driver findByMobile(String mobileNo);
	
	@Query("from Driver d where d.rating >= 4.5")
	public List<Driver> getBestRatingDriverList();
	
	public Driver findByDriverId(Integer driverId);
	
	
	
}
