package com.amdocs.casestudy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.casestudy.entities.Driver;
import com.amdocs.casestudy.entities.RouteEntity;
import com.amdocs.casestudy.repo.DriverRepo;
import com.amdocs.casestudy.repo.RouteRepository;



@Service
public class RouteServices {
   
   
   private RouteRepository routeRepo;
   private DriverRepo driverRepo;
   
   @Autowired
    public RouteServices(RouteRepository routeRepo, DriverRepo driverRepo) {
	this.routeRepo = routeRepo;
	this.driverRepo = driverRepo;
}

	public RouteEntity addRoute(RouteEntity route) {
	// TODO Auto-generated method stub
	          
//		   Driver driver=  driverRepo.findById(driverId).orElse(null);
//		   if(driver!=null) route.setDriver(driver);
	       return routeRepo.save(route);
	
     }

	public RouteEntity updateRoute(int routeid ,  Integer driverid, RouteEntity route ) {
		
	
	  RouteEntity existingRoute = routeRepo.findById(routeid).orElse(null);
		
		if(existingRoute!=null)
		{
			  if(driverid!=null) {
					Driver driver =  driverRepo.findById(driverid).orElse(null);
					System.out.println(driver.getLastname());
					if(driver!=null)existingRoute.setDriver(driver);
				  }
				  if(route.getDestination()==null) {
					  route.setDestination(existingRoute.getDestination());
				  }
				  
				  if(route.getSource()==null) {
					  route.setSource(existingRoute.getSource());
				  }
			existingRoute.setSource(route.getSource());
			existingRoute.setDestination(route.getDestination());
		    return routeRepo.save(existingRoute);
		}
		return null;
		
	}

	public List<RouteEntity> getAllRoutes() {
		// TODO Auto-generated method stub
		
		return routeRepo.findAll();
	}

	public RouteEntity getRouteById(int routeid) {
		// TODO Auto-generated method stub
		return routeRepo.findById(routeid).orElse(null);
	}

	public void deleteRoute(int routeid) {
		// TODO Auto-generated method stub
		
		 routeRepo.deleteById(routeid);
	}
	
	
	
}
