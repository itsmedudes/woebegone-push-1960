package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.AdminException;
import com.app.model.Admin;
import com.app.model.Driver;
import com.app.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/insertadmin")
	public ResponseEntity<Admin> insertAdminHandler(@RequestBody Admin admin) throws AdminException {
		Admin savedAdmin = adminService.insertAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
	}
	
	@PutMapping("/updateadmin")
	public ResponseEntity<String> updateAdminHandler(@RequestBody Admin admin) throws AdminException {
		Admin updatedAdmin = adminService.updateAdmin(admin);
		return new ResponseEntity<String>("admin updated "+updatedAdmin,HttpStatus.ACCEPTED); 

	}
	
	
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<Admin> deleteMappingHandler(@PathVariable("adminId") Integer adminId) throws AdminException {
		Admin deleteAdmin = adminService.deleteAdmin(adminId);
		return new ResponseEntity<Admin>(deleteAdmin,HttpStatus.OK);
	}
	
	
}
