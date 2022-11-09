package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	@Column(unique = true)
	@NotNull
	private String licenceNo;
	private Float rating;
	
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Cab cab;
}
