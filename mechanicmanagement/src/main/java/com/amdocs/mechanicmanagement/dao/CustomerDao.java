package com.amdocs.mechanicmanagement.dao;

import java.sql.SQLException;

import com.amdocs.mechanicmanagement.entity.Customer;



public interface CustomerDao {
	
	boolean add(Customer customer) throws SQLException;
	int update(Customer customer) throws SQLException;
	int delete(Customer customer) throws SQLException;
	int addApp(int custId,int mechId) throws SQLException;
	int updateApp(int custId,int mechId) throws SQLException;
	int deleteApp(int custId,int mechId) throws SQLException;
	void showAllDetails() throws SQLException;
	void showCustDetails(int cust_id) throws SQLException;
	void showMechDetails(int mech_id) throws SQLException;
	void showAllCustomerDetails() throws SQLException;
	
	
	
	

}
