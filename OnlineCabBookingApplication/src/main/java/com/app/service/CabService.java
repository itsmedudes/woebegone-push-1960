package com.app.service;

import java.util.List;

import com.app.exception.CabException;
import com.app.model.Cab;

public interface CabService {

	public Cab insertCab(Cab cab) throws CabException;
	
	public Cab updateCab(Cab cab) throws CabException;
	
	public Cab deleteCab(Integer cabId) throws CabException;
	
	public List<Cab> viewCabsOfType(String carType) throws CabException;
	
	public int countCabsOFType(String carType) throws CabException;
	
	
	
}
