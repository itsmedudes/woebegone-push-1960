package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
}
