package com.amdocs.casestudy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.casestudy.entities.RouteEntity;



@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {
       


}
