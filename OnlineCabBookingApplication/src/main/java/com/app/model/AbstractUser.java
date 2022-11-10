package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AbstractUser {

	
	@Size(min = 5, max = 50, message = "{usernameRange}")
	@NotNull(message = "{notNull}")
	@Column(unique = true)
	private String username;
	
	@Size(min = 6, max = 20, message = "{passwordRange}")
	@NotNull(message = "{notNull}")
	private String password;
	

	private String address;
	
	@Size(max = 10, message = "{mobileRange}")
	@Pattern(regexp = "[789]{1}[0-9]{9}", message = "{MobileRange}")
	private String mobileNumber;
	
	@Email
	@NotNull(message = "{notNull}")
	private String email;
	
	
}
