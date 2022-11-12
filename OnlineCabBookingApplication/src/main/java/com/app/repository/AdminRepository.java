package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Optional<Admin> findByUserUsername(String username) ;
	
	public Optional<Admin> findByUserMobile(String username) ;
	
}
