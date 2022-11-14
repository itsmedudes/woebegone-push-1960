package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.CustomerLogin;

@Repository
public interface CustomerLoginDao extends JpaRepository<CustomerLogin, Integer>{
	
}
