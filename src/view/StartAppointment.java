/*package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import model.Customer;
import model.Pet;
import model.Services;


public class StartAppointment {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Welcome to DoggyShic -----------");
		System.out.println("Let's schedule your pet's grooming appointment--");
		LocalDate date = setAppointmentDate();
		LocalTime start = setAppointmentTime();
		System.out.println();
		System.out.println("Please provide more information for your appointment on " + date + " at " + start + "--");
		
		Customer customer = getCustomerInfo();
		System.out.println();
		
		Pet dog = getPetInfo();
		System.out.println();
		
			
		Services service = new Services();
		System.out.println();
		
		System.out.println(service.viewPlanDetails());
			
		System.out.println("Please enter the service you want.");
		String planName = in.nextLine();
		
		service.setPlanName(planName);
		System.out.println("PlanName = " + planName);
		
				
		System.out.println("Do you want an instore(I) appointment or a mobile(M) appointment.  Please enter either I or M. ");
		String appointmentType = in.nextLine();
		
		String apptDesc;
		final String INSTORE = "In Store";
		final String MOBILE = "Mobile";
		
		if(appointmentType.equalsIgnoreCase("I")){
			apptDesc = INSTORE;
		}else {
			apptDesc = MOBILE;
		}
		
		
		//if (appointmentType.equalsIgnoreCase("I")){
			System.out.println(appt.printReceipt());
		//}else {
		//	System.out.println(appt2.printReceipt());
		//}
		
	}

	private static Pet getPetInfo() {
		// TODO Auto-generated method stub

		System.out.println("Please enter your pets name");
		String name = in.nextLine();
		System.out.println("Please enter your pets weight");
		double weight = in.nextDouble();
		System.out.println("Does you pet current on shots?  Y or N");
		String updateOnShots = in.next();
		boolean hasShots = false;
		if (updateOnShots.equalsIgnoreCase("Y")) {
			hasShots = true;
		}else {
			System.out.println("Shots are required and service will not be provided without current vacinations.");
		}
		in.nextLine();
		
		Pet dog = new Pet(name, weight, hasShots);
		return dog;
	}

	private static Customer getCustomerInfo() {
		// TODO Auto-generated method stub
		System.out.println("Please enter your name.");
		String customerName = in.nextLine();
		System.out.println("Please enter your phone number.");
		String phoneNumber = in.nextLine();
		System.out.println("Please enter your address. ");
		String address = in.nextLine();
		Customer customer = new Customer(customerName, phoneNumber, address);
		return customer;
	}
	public static LocalDate setAppointmentDate() {
		int year = LocalDate.now().getYear();
		int month = 0;
		System.out.print("Please enter month (1-12): ");
		if (in.hasNextInt()) {
			month = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter month (1-12): ");
			month = in.nextInt();
			in.nextLine();
		}
		while (!(month >= 1 && month <= 12)) {
			System.out.print("Invalid input. Please enter month (1-12): ");
			month = in.nextInt();
			in.nextLine();
		}
		
		int day = 0;
		System.out.print("Please enter day: ");
		if (in.hasNextInt()) {
			day = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter day as numeral: ");
			day = in.nextInt();
			in.nextLine();
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day < 1 || day > 30) {
				System.out.print("Invalid input. Please enter day (1-30): ");
				day = in.nextInt();
				in.nextLine();
			}
		} else if (month == 2) {
			boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
			if (isLeapYear) {
				if (day < 1 || day > 29) {
					System.out.print("Invalid input. Please enter day (1-29): ");
					day = in.nextInt();
					in.nextLine();
				} else {
					
				}
			}
		} else {
			if (day < 1 || day > 31) {
				System.out.print("Invalid input. Please enter day (1-31): ");
				day = in.nextInt();
				in.nextLine();
			}
		}
		
		LocalDate appointmentDate = LocalDate.of(year, month, day);
		return appointmentDate;
	}
	
	public static LocalTime setAppointmentTime() {
		System.out.print("Would you like an AM or PM appointment? ");
		String input = in.nextLine();
		while (!(input.equalsIgnoreCase("am") || input.equalsIgnoreCase("pm"))) {
			System.out.print("Invalid input. Please enter AM or PM: ");
			input = in.nextLine();
		}
		int hour = 0;
		System.out.print("Please enter the start time of your appointment--" + "\nHour: ");
		if (in.hasNextInt()) {
			hour = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter hour (1-12): ");
			hour = in.nextInt();
			in.nextLine();
		}
		while (!(hour >= 1 && hour <= 12)) {
			System.out.print("Invalid input. Please enter hour (1-12): ");
			hour = in.nextInt();
			in.nextLine();
		}
		if (input.equalsIgnoreCase("pm") && hour != 12) {
			hour += 12;
		}
		if (input.equalsIgnoreCase("am") && hour == 12) {
			hour = 0;
		}
		int minute = 0;
		System.out.print("Minute: ");
		if (in.hasNextInt()) {
			minute = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter minute (01-59): ");
			minute = in.nextInt();
			in.nextLine();
		}
		while (!(minute >= 1 && minute <= 59)) {
			System.out.print("Invalid input. Please enter minute (01-59): ");
			minute = in.nextInt();
			in.nextLine();
		}
		
		LocalTime startTime = LocalTime.of(hour, minute);
		return startTime;
	}
}

*/