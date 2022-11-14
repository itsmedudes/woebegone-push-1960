package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.AdminLogin;

@Repository
public interface AdminLoginDao extends JpaRepository<AdminLogin, Integer> {

}
