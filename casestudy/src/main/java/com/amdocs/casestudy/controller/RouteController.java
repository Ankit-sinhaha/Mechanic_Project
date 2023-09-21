package com.amdocs.casestudy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.casestudy.entities.Driver;
import com.amdocs.casestudy.entities.RouteEntity;
import com.amdocs.casestudy.services.DriverServices;
import com.amdocs.casestudy.services.RouteServices;



@RestController
@RequestMapping("/api/routes")

public class RouteController {

	private RouteServices routeServices;
    private DriverServices driverServices;
	
    @Autowired
	public RouteController(RouteServices routeServices, DriverServices driverServices) {
		this.routeServices = routeServices;
		this.driverServices = driverServices;
	}
    
    
	@PostMapping("/create-route/{driverid}")
	@ResponseStatus(HttpStatus.CREATED)
	public RouteEntity createRoute( @PathVariable int driverid, @RequestBody RouteEntity route) {
		
		    Driver driver = driverServices.getDriverbyID(driverid);
		  if(driver!=null) route.setDriver(driver);
		  else {
			  throw new NoSuchElementException("The driver provided does not exist!!");
		  }
		   return routeServices.addRoute(route);
				
	}
	
	@PutMapping("/update-route/{routeid}")
	@ResponseStatus(HttpStatus.OK)
	public RouteEntity updateRoute(@PathVariable int routeid ,@RequestParam("driverid") Integer driverid ,@RequestBody RouteEntity route) {
		
		System.out.println(driverid);
		return routeServices.updateRoute(routeid,driverid,route);
	}
	
	
	@GetMapping("/get-allRoute")
	@ResponseStatus(HttpStatus.OK)
	public List<RouteEntity> getAllRoutes(){
		
		return routeServices.getAllRoutes();
	}

	@GetMapping("/getRoute/{routeid}")
	@ResponseStatus(HttpStatus.OK)
	public RouteEntity getRouteById(@PathVariable int routeid) {
		
		return routeServices.getRouteById(routeid);
	}
    
	@DeleteMapping(value = "/deleteRoute/{routeid}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteRoute(@PathVariable int routeid) {
		
		routeServices.deleteRoute(routeid);
		return "{\"message\":\"Deleted Succesfully\"}";

		
	}
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Map<String, String>> handleException(NoSuchElementException e){
		
		Map<String, String> errorResponse = new HashMap<String, String>();
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", "failed");
		    
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
}

