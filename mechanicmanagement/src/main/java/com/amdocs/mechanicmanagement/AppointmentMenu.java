package com.amdocs.mechanicmanagement;

import java.sql.SQLException;
import java.util.Scanner;

import com.amdocs.mechanicmanagement.dao.CustomerDao;
import com.amdocs.mechanicmanagement.dao.impl.CustomerDaoImpl;
import com.amdocs.mechanicmanagement.exception.SystemException;

public class AppointmentMenu {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void getAppointmentMenu() {
		try {
			while (true) {
				System.out.println("\n 2.Book an appointment");
				System.out.println("\n 3.Modify appointment details");
				System.out.println("\n 4.Delete an appointment");
				System.out.println("\n 5.View mechanic record");
				System.out.println("\n 6.View all records");
				System.out.println("\n 1.Exit");
				int temp1 = Integer.parseInt(scanner.nextLine());
				switch(temp1) {
				case 2:
					bookAppointment();
					break;
				case 3:
					modifyAppointment();
					break;
				case 4:
					deleteAppointment();
					break;
				case 5:
					viewMechanicDetails();
					break;
				case 6:
					viewAllDetails();
					break;
				case 1:
					System.exit(0);
				default:
					System.out.println("Try again");
					break;		
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Number Format : " + e.getMessage());
		} catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
	}
	
	
	
	private static CustomerDao dao = new CustomerDaoImpl();
	
	
	private static void bookAppointment() throws SystemException,SQLException {
		
		try {
			System.out.println("Enter the customer id: ");
			int custId = scanner.nextInt();
					
			System.out.println("Enter Mechanic id: ");
			int mechId = scanner.nextInt();
			scanner.nextLine();
			dao.addApp(custId,mechId );
			
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

	}
	
	
	private static void modifyAppointment() throws SystemException,SQLException {
		
		try {
			System.out.println("Enter the customer id: ");
			int custId = scanner.nextInt();
					
			System.out.println("Enter Mechanic id: ");
			int mechId = scanner.nextInt();
			scanner.nextLine();
			dao.updateApp(custId,mechId );
			
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

	}
	
	
	private static void deleteAppointment() throws SystemException,SQLException {
		
		try {
			System.out.println("Enter the customer id: ");
			int custId = scanner.nextInt();
					
			System.out.println("Enter Mechanic id: ");
			int mechId = scanner.nextInt();
			scanner.nextLine();
			dao.deleteApp(custId,mechId );
			
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

	}
	
	private static void viewMechanicDetails() throws SystemException, SQLException {
		try {
			System.out.println("Enter the Mechanic id: ");
			int mech_id = Integer.parseInt(scanner.nextLine());	
			dao.showMechDetails(mech_id);						
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

		
	}
	
	private static void viewAllDetails() throws SystemException, SQLException {
		dao.showAllDetails();
		
	}
	
	

}
