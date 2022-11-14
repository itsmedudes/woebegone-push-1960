package com.app.services;

import java.util.List;

import com.app.exception.CabException;
import com.app.model.Cab;
import com.app.model.CabType;

public interface CabService {
	
	public Cab insertCab(Cab cab) throws CabException;
	
	public Cab updateCab(Cab cab) throws CabException;
	
	public Cab deleteCab(Integer id) throws CabException;
	
	public List<Cab> viewCabsOfType(CabType carType) throws CabException;
	
	public Integer countCabsOfType(CabType carType) throws CabException;

}







