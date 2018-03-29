/*package Test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import model.Customer;
import model.InStoreAppointment;
import model.MobileAppointment;
import model.Pet;
import model.Services;

public class GroomingTester {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter your name.");
		String customerName = in.nextLine();
		System.out.println("Please enter your phone number.");
		String phoneNumber = in.nextLine();
		System.out.println("Please enter your address. ");
		String address = in.nextLine();
		
		
		Customer customer = new Customer( "Rhonda", "Stevens", "7480 SW 19th St",  "Ankeny", "IA",  "50023" ,"515-975-1111");
		Pet dog = new Pet("D1234", "Shea", 4, 'Y');
		Services services = new Services("W12345", "basic", 30);
		//InStoreAppointment appt = new InStoreAppointment(customer, dog, services, LocalDate.of(2018, 4, 11), LocalTime.of(12, 30), LocalTime.of(15, 15));
		System.out.println("In Store Appointment");
		//System.out.println(appt.printReceipt());
		
		Customer customer2 = new Customer("S123457", "Rhonda", "515-975-1112", "7482 SW 19th St.", "Ankeny, IA","50023", "515-515-5151");
		Pet dog2 = new Pet("D1235", "Shea", 80, 'Y');
		Services services2 = new Services("W12346", "Super", 30);

		MobileAppointment appt2 = new MobileAppointment (customer2, dog2, services2, LocalDate.of(2018, 4, 11), LocalTime.of(12, 30), LocalTime.of(15, 15), "711 High Street", 10);  
		System.out.println("Mobile Appointment");
		System.out.println(appt2.printReceipt());
		//appt.printReceipt();
	}
} 
*/