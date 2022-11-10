package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CabException;
import com.app.model.Cab;
import com.app.service.CabService;

@RestController
public class CabController {

	@Autowired
	private CabService cabService;
	
	
	@PostMapping("/cabregister")
	public ResponseEntity<Cab> registerCabHandler(@Valid @RequestBody Cab cab) throws CabException{
		
		Cab registerCab = cabService.insertCab(cab);
		
		return new ResponseEntity<Cab>(registerCab,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/cabupdate")
	public ResponseEntity<Cab> updateCabHandler(@Valid @RequestBody Cab cab) throws CabException{
	
		Cab registerCab = cabService.updateCab(cab);
		
		return new ResponseEntity<Cab>(registerCab,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{cabid}")
	public ResponseEntity<Cab> deleteCabHandler(@PathVariable("cabid")Integer cabId) throws CabException{
	
		Cab deleteCab = cabService.deleteCab(cabId);
		
		return new ResponseEntity<Cab>(deleteCab,HttpStatus.OK);
	}
	
	
	@GetMapping("/cab/{cartype}")
	public ResponseEntity<List<Cab>> viewcabsofTypesHandler(@PathVariable("cartype") String cartype) throws CabException{
	
		List<Cab> cab = cabService.viewCabsOfType(cartype);
		
		return new ResponseEntity<List<Cab>>(cab,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/cabs/{cabtype}")
	public ResponseEntity<Integer> caountCabsOFTypesHandler(@PathVariable("cabtype") String cartype) throws CabException{
		
		int count = cabService.countCabsOFType(cartype);
		
		return new ResponseEntity<>(count,HttpStatus.OK);
		
	}

	
}
