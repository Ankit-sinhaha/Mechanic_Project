package com.amdocs.casestudy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="ROUTES")
public class RouteEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private Integer id;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	
	 @ManyToOne
	 @JoinColumn(name = "driver_id")
	 private Driver driver;

	
	
	
}
