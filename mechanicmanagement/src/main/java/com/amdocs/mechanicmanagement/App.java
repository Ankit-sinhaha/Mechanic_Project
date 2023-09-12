package com.amdocs.mechanicmanagement;

import java.util.Scanner;

public class App 
{
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main( String[] args )
    {
        
		try {
			while (true) {
				System.out.println("\n 1.Customer");
				System.out.println("\n 2.Mechanic ");
				System.out.println("\n 3.Appointment");
				System.out.println("\n 4.Service");
				System.out.println("\n 5.Exit");
				int ch = Integer.parseInt(scanner.nextLine());
				switch (ch) {
				case 1:
					CustomerMenu.getCustomerMenu();
					break;
				case 2:
					AppointmentMenu.getAppointmentMenu();
					break;
				case 3:
					System.out.println("\n This service is currently not available.");
					break;
				case 4:
					System.out.println("\n This service is currently not available.");	
					break;
				case 5:
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
	

    }

