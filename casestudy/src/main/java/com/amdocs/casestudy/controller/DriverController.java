package com.amdocs.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.casestudy.entities.Driver;
import com.amdocs.casestudy.services.DriverServices;



@Controller
public class DriverController {
	
	private DriverServices driverServices ;
	
	@Autowired
     public DriverController(DriverServices driverServices) {
		// TODO Auto-generated constructor stub
		this.driverServices=driverServices;
	}
  
	@RequestMapping("/")
	public String loadForm(Model model) {
		
		Driver driver = new Driver();
		model.addAttribute("driver", driver);
		return "driver";
	}
	
	@RequestMapping("/create-drivers")
	public String insert(@ModelAttribute("driver")Driver driver,Model model) {
		
	
		boolean savedData = driverServices.saveData(driver);
		
	     String msg="";
		
		if(savedData)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		
		return "driver";
		
	}
	
	@RequestMapping("/viewAll")
	public String viewAll(Model model) {
		
     List<Driver> allDrivers = driverServices.getAllDrivers();
		
		model.addAttribute("drivers", allDrivers);
		return "viewDriver";
		
	}
	
	@RequestMapping("/editDriver")
	public String editDriver(@RequestParam("driver_id")   int id ,Model model) {
		
		Driver driver = driverServices.getDriverbyID(id);
		model.addAttribute("driver",driver);
		return "editDriver";
	}
	
	@RequestMapping("/update")
	public String updateDriver(@ModelAttribute("driver")Driver driver) {
		
	     driverServices.saveData(driver);
		return "redirect:/viewAll";
	}
	
	@RequestMapping("/deleteDriver")
	public String deleteDriver(@RequestParam("driver_id") int id) {
		
		driverServices.deleteDriver(id);
		
		return "redirect:/viewAll";
	}
	
	
	
}

