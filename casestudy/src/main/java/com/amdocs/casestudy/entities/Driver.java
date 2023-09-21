package com.amdocs.casestudy.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Driver")
public class Driver {
	
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
     
	@Column(name = "EMAILID")
	private String emailID;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="CONTACT")
	private String contact;
	
	@Column(name="LICENSE_NO")
	private String licenseNumber;
	 
    
	@OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private Set<RouteEntity> route = new HashSet<>();
	

	public Driver() {
		
	}
     

	public Driver(Integer id, String firstName, String lastName, String emailID, Integer age, String contact,
			String licenseNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.age = age;
		this.contact = contact;
		this.licenseNumber = licenseNumber;
	}


	


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmailID() {
		return emailID;
	}



	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getLicenseNumber() {
		return licenseNumber;
	}



	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	


}
