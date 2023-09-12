package com.amdocs.mechanicmanagement;

import com.amdocs.mechanicmanagement.dao.*;
import com.amdocs.mechanicmanagement.dao.impl.*;
import java.sql.SQLException;
import java.util.Scanner;
import com.amdocs.mechanicmanagement.entity.Customer;
import com.amdocs.mechanicmanagement.exception.*;

public class CustomerMenu {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void getCustomerMenu() {
		try {
			while (true) {
				System.out.println("\n 2.Register Customer");
				System.out.println("\n 3.Modify Customer details");
				System.out.println("\n 4.Delete Customer record");
				System.out.println("\n 5.View details");
				System.out.println("\n 6.View all customer details");
				System.out.println("\n 1.Exit");
				int ch = Integer.parseInt(scanner.nextLine());
				switch(ch) {
				case 2:
					registerCustomer();
					break;
				case 3:
					modifyCustomer();
					break;
				case 4:
					removeCustomer();
					break;
				case 5:
					viewCustDetails();
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
		}catch (invalidPhoneNumberException e) {
			System.out.println("Error"+e.getMessage());
		}
		catch (NumberFormatException e) {
			System.out.println("Number Format : " + e.getMessage());
		} catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
	}
	
	
	private static CustomerDao dao = new CustomerDaoImpl();
	
	private static Customer createCustomer() throws SystemException, invalidPhoneNumberException {
		Customer obj = new Customer();
		try {
			System.out.println("Enter The First Name: ");
			String firstName = scanner.nextLine();
			obj.setFirstName(firstName);
			firstName = obj.getFirstName();
			System.out.println("Enter The Last Name: ");
			String lastName = scanner.nextLine();
			obj.setLastName(lastName);
			lastName = obj.getLastName();
			System.out.println("Enter Your age: ");
			int age = Integer.parseInt(scanner.nextLine());
			obj.setAge(age);
			age = obj.getAge();
			System.out.println("Enter your company name: ");
			String companyName = scanner.nextLine();
			obj.setCompanyName(companyName);
			companyName = obj.getCompanyName();
			System.out.println("Enter Phone number: ");
			String phoneNumber = scanner.nextLine();
			if(isValidPhoneNumber(phoneNumber)) {
				obj.setPhno(phoneNumber);
				phoneNumber = obj.getPhno();
			}else {
				throw new invalidPhoneNumberException("Entered data is invalid");
			}
		}
		catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

		return obj;
	}
	
	
	private static void registerCustomer() throws invalidPhoneNumberException {
		Customer createCustomer;
		try {
			createCustomer = createCustomer();
			dao.add(createCustomer);
		} catch (SQLException e) {
			System.out.println(e);
		}catch (SystemException e) {
			System.out.println(e);
		}

	}
	
	
	
	
	private static Customer updateCustomer() throws SystemException, invalidPhoneNumberException {
		Customer obj = new Customer();
		try {
			System.out.println("Enter the customer id: ");
			int id = Integer.parseInt(scanner.nextLine());
			obj.setId(id);
			id = obj.getId();		
			System.out.println("Enter The First Name: ");
			String firstName = scanner.nextLine();
			obj.setFirstName(firstName);
			firstName = obj.getFirstName();
			System.out.println("Enter The Last Name: ");
			String lastName = scanner.nextLine();
			obj.setLastName(lastName);
			lastName = obj.getLastName();
			System.out.println("Enter Your age: ");
			int age = Integer.parseInt(scanner.nextLine());
			obj.setAge(age);
			age = obj.getAge();
			System.out.println("Enter your company name: ");
			String companyName = scanner.nextLine();
			obj.setCompanyName(companyName);
			companyName = obj.getCompanyName();	
			System.out.println("Enter Phone number: ");
			String phoneNumber = scanner.nextLine();
			if(isValidPhoneNumber(phoneNumber)) {
				obj.setPhno(phoneNumber);
				phoneNumber = obj.getPhno();
			}else {
				throw new invalidPhoneNumberException("Entered data is invalid");
			}
		
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

		return obj;
	}
	
	
	private static void modifyCustomer() throws invalidPhoneNumberException {
		Customer updateCustomer;
		try {
			updateCustomer = updateCustomer();
			dao.update(updateCustomer);
		} catch (SQLException e) {
			System.out.println(e);
		}catch (SystemException e) {
			System.out.println(e);
		}

	}
	
	private static Customer deleteCustomer() throws SystemException {
		Customer obj = new Customer();
		try {
			System.out.println("Enter the customer id: ");
			int id = scanner.nextInt();
			obj.setId(id);
			scanner.nextLine();
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

		return obj;
	}
	
	private static void removeCustomer() {
		Customer deleteCustomer;
		try {
			deleteCustomer = deleteCustomer();
			dao.delete(deleteCustomer);
		} catch (SQLException e) {
			System.out.println(e);
		}catch (SystemException e) {
			System.out.println(e);
		}

	}
	
	private static void viewCustDetails() throws SystemException, SQLException {
		try {
			System.out.println("Enter the customer id: ");
			int cust_id = Integer.parseInt(scanner.nextLine());	
			dao.showCustDetails(cust_id);						
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

		
	}
	
	private static void viewAllDetails() throws SystemException, SQLException {
		dao.showAllCustomerDetails();
		
	}
	
	private static boolean isValidPhoneNumber(String phno) {
		return phno.matches("\\d{10}");
	}


}
