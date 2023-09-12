package com.amdocs.mechanicmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.amdocs.mechanicmanagement.dao.CustomerDao;
import com.amdocs.mechanicmanagement.entity.Customer;
import com.amdocs.mechanicmanagement.util.DbUtil;



public class CustomerDaoImpl implements CustomerDao {
	
	private static final String INSERT_CUSTOMER="insert into customer(first_name, last_name,ph_number,age,company_name) values(?,?,?,?,?)";
	
	private static final String UPDATE_CUSTOMER="update customer set first_name=? , last_name=?,ph_number=?,age=?,company_name=? where id=?";
	
	private static final String DELETE_CUSTOMER="delete from customer where id=?";
	
	private static final String ADD_APPOINTMENT="insert into appointment_table(cust_id,mech_id) values (?,?)";
	
	private static final String UPDATE_APPOINTMENT="update appointment_table set mech_id=? where cust_id=?";
	
	private static final String DELETE_APPOINTMENT="delete from appointment_table where cust_id=? and mech_id=?";
	
	private final static String SELECT_BY_CUST_ID = "SELECT * FROM CUSTOMER WHERE id=?";
	
	private final static String SELECT_BY_MECH_ID = "SELECT * FROM mechanic_table WHERE id=?";
	
	private final static String SHOW_ALL_CUSTOMER_DETAILS = "SELECT * FROM CUSTOMER";
	
	
	
	private  Connection connection = DbUtil.getConnection();
	
	public boolean add(Customer customer) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
		// Set The value
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setString(3, customer.getPhno());
		ps.setInt(4, customer.getAge());
		ps.setString(5, customer.getCompanyName());
		
		
		//Execute Statement
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
	}

	@Override
	public int update(Customer customer) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(UPDATE_CUSTOMER);
		
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setString(3, customer.getPhno());
		ps.setInt(4, customer.getAge());
		ps.setString(5, customer.getCompanyName());
		ps.setInt(6, customer.getId());

		int executeUpdate = ps.executeUpdate();
		ps.close();
		return executeUpdate;
	}

	@Override
	public int delete(Customer customer) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(DELETE_CUSTOMER);
		ps.setInt(1, customer.getId());
		int executeUpdate = ps.executeUpdate();
		ps.close();
		return executeUpdate;
	}

	@Override
	public int addApp(int custId, int mechId) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(ADD_APPOINTMENT);
		ps.setInt(1, custId);
		ps.setInt(2, mechId);
		int executeUpdate = ps.executeUpdate();
		ps.close();
		return executeUpdate;
		
	}

	@Override
	public int updateApp(int custId, int mechId) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(UPDATE_APPOINTMENT);
		ps.setInt(1, mechId);
		ps.setInt(2, custId);
		int executeUpdate = ps.executeUpdate();
		ps.close();
		return executeUpdate;

	}

	@Override
	public int deleteApp(int custId, int mechId) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(DELETE_APPOINTMENT);
		ps.setInt(1, custId);
		ps.setInt(2, mechId);
		int executeUpdate = ps.executeUpdate();
		ps.close();
		return executeUpdate;
	}

	@Override
	public void showCustDetails(int custId) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(SELECT_BY_CUST_ID);
		ps.setInt(1, custId);
		ResultSet result = ps.executeQuery();
		
		if(result.next()) {
			String customerFirstName = result.getString("first_name");
			String customerLastName = result.getString("last_name");
			String phoneNumber = result.getString("ph_number");
			int age = result.getInt("age");
			String companyName = result.getString("company_name");
			
			
			System.out.println("CustomerId:"+" "+custId+" "+"Customer Name:" +" "+customerFirstName+" "+customerLastName +" "+"PhoneNumber:"+" "+phoneNumber
					+" "+"Age:"+" "+age+" "+"Companyname:"+" "+companyName);
			
		}else {
			System.out.println(" No customer with this id");
		}
		ps.close();
			
	}
	
	public void showMechDetails(int mech_id) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(SELECT_BY_MECH_ID);
		ps.setInt(1, mech_id);
		ResultSet result = ps.executeQuery();
		
		if(result.next()) {
			String mechanicFirstName = result.getString("first_name");
			String mechanicLastName = result.getString("last_name");
			
			System.out.println("Mechanic Name:" + mechanicFirstName+" "+mechanicLastName);
			
		}else {
			System.out.println(" No mechanic with this id");
		}
		ps.close();	
	}
	
	@Override
	public void showAllCustomerDetails() throws SQLException {
		PreparedStatement ps=connection.prepareStatement(SHOW_ALL_CUSTOMER_DETAILS);
		
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			int custId = result.getInt("id");
			String customerFirstName = result.getString("first_name");
			String customerLastName = result.getString("last_name");
			String phoneNumber = result.getString("ph_number");
			int age = result.getInt("age");
			String companyName = result.getString("company_name");
			
			System.out.println("CustomerId"+" "+custId+" "+"Customer Name:" +" "+customerFirstName+" "+customerLastName +" "+"PhoneNumber:"+" "+phoneNumber
					+" "+"Age:"+" "+age+" "+"Companyname:"+" "+companyName);
			
		}
		ps.close();
		
	}
	

	@Override
	public void showAllDetails() throws SQLException {
		String SHOW_ALL_APPOINTMENT="select c.id as customer_id,c.first_name as customer_firstname,"
				+ "c.last_name as customer_lastname,"
				+ "m.first_name as mechanic_firstname,m.last_name as mechanic_lastname "
				+ "from appointment_table ap inner join customer c on ap.cust_id=c.id "
				+ "inner join mechanic_table m on ap.mech_id=m.id ";
		
		PreparedStatement ps=connection.prepareStatement(SHOW_ALL_APPOINTMENT);
		
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			
			String customerFirstName = result.getString("customer_firstname");
			String customerLastName = result.getString("customer_lastname");
			String mechanicFirstName = result.getString("mechanic_firstname");
			String mechanicLastName = result.getString("mechanic_lastname");
			
			System.out.println( "Customer Name:" + customerFirstName+" "+customerLastName +" "+"has appointment with "+" "
					+ "Mechanic Name:" + mechanicFirstName + " " +mechanicLastName );
			
		}
		ps.close();
		
	}


}
