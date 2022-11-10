package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CabException;
import com.app.model.Cab;
import com.app.repository.CabRepository;



@Service
public class CabServiceImpl implements CabService {
	
	@Autowired
	private CabRepository cabRepository;
	
	

	@Override
	public Cab insertCab(Cab cab) throws CabException {
		if(cab != null) {
			return cabRepository.save(cab);
		}
		else
			throw new CabException("We cannot Add Please Enter valid information");
	}
	
	

	@Override
	public Cab updateCab(Cab cab) throws CabException {
		
      Optional<Cab> ans = cabRepository.findById(cab.getCabId());
		
		if(ans.isPresent()) {
			return cabRepository.save(cab);
		}
		else
			throw new CabException("we cannot cannot find details of cab please enter valid details");
	}
	
	

	@Override
	public Cab deleteCab(Integer cabId) throws CabException {
		  Optional<Cab> opt= cabRepository.findById(cabId);
			
			if(opt.isPresent()) {
				
				
				Cab existingCab= opt.get();
				cabRepository.delete(existingCab);
				
				return existingCab;
				
				
			}else
				throw new CabException("Cab does not exist with CabId :"+cabId);	
			}
	
	

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {
		
		List<Cab> cabs = cabRepository.findByCarType(carType);
		
		
		if(cabs.size() == 0)
			throw new CabException("No Cabs Found");
		else {
			return cabs;
		}
			
		
		
		

		
	}



	@Override
	public int countCabsOFType(String carType) throws CabException {
		
		 List<Cab> cabList = cabRepository.findByCarType(carType);
		 
		 if(cabList.size() > 0) {
			 
			 return cabList.size();
		 }
		 else
			 throw new CabException("No such cabs");
		
		
	}

	
	
}
