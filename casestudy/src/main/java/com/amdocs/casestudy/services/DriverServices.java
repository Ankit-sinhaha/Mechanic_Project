package com.amdocs.casestudy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.casestudy.entities.Driver;
import com.amdocs.casestudy.repo.DriverRepo;



@Service
public class DriverServices {
        
	@Autowired
	private DriverRepo driverRepo;
	
	
	
	public boolean saveData(Driver driver) {
		
		Driver driverSaved = driverRepo.save(driver);
		
		if(driverSaved!=null) return true;
		return false;
		
		
	}



	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		List<Driver> drivers = driverRepo.findAll();
		return drivers;
	}



	public Driver getDriverbyID(int id) {
		// TODO Auto-generated method stub
		Optional<Driver> driverId = driverRepo.findById(id);
		Driver driver = driverId.get();
		return driver;
	}



	public void deleteDriver(int id) {
		// TODO Auto-generated method stub
		Driver driver = getDriverbyID(id);
		
		if(driver!=null) {
			driverRepo.delete(driver);
		}
	}
}

