package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.DriverException;
import com.app.model.Cab;
import com.app.model.Driver;
import com.app.repository.CabRepository;
import com.app.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private CabRepository cabRespository;
	
	@Override
	public Driver insertDriver(Driver driver) throws DriverException{
		
		if(driver!=null) {
			driver.setCab((Cab)cabRespository);
			
			return driverRepository.save(driver);
		}
		else throw new DriverException("We Cant Add This Driver Please Enter The Valid Information");
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException {
		Optional<Driver> found = driverRepository.findById(driver.getDriverId());
		
		if(found.isPresent()) return driverRepository.save(driver);

		else throw new DriverException("We Can't Found Any Driver with this driver id "+ driver.getDriverId());		
	}

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException {
		Optional<Driver> found = driverRepository.findById(driverId);
		
		if(found.isPresent()) {
			Driver deletedDriver = found.get();
			driverRepository.delete(deletedDriver);
			return deletedDriver;
		}
		else throw new DriverException("We Can't Found Any Driver with this driver id "+ driverId);
		
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverException {
		
		List<Driver> bestDriverList = driverRepository.getBestRatingDriverList();
		
		if(!bestDriverList.isEmpty()) {
			return bestDriverList;
		}
		else throw new DriverException("Driver not found Who Has a 4.5 Rating");
		
	}

	@Override
	public Driver viewDriver(Integer driverId) throws DriverException {
		Driver driver = driverRepository.findByDriverId(driverId);
		
		if(driver!=null) return driver;
		else throw new DriverException("Driver Not found With This Driver Id "+ driverId);
		
	}
	
}
