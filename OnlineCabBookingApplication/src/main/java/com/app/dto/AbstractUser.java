package com.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractUser {
	
	@NotNull(message = "Please Enter The Username")
	private String username;
	
	@NotNull(message = "Password Enter The Password")
	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
	private String password;
	
	@NotNull(message = "Fill The address")
	private String address;
	
	@NotNull(message = "Please enter the mobile Number")
	@Column(unique = true)
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	private String mobileNumber;
	

	@Column(unique = true)
	@Email(message = "Please enter a valid Email Id")
	private String email;
}
