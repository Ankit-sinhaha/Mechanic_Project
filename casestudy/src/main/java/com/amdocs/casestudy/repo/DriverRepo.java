package com.amdocs.casestudy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.casestudy.entities.Driver;


@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {
    
	   
}
