package Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import controller.AppointmentHelper;
import controller.CustomerHelper;
import controller.PetHelper;
import controller.ServicesHelper;
import model.Appointment;
import model.Customer;
import model.Pet;
import model.Services;




public class AddAppointmentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerHelper customerhelp = new CustomerHelper();
		Customer customer1 = new Customer( "Scott", "Stevens", "7480 SW 19th St",  "Ankeny", "IA",  "50023" ,"5159751111");
		customerhelp.insertCustomer(customer1);
		
		PetHelper pethelp = new PetHelper();
		Pet pet1 = new Pet("Jim", 40.0, 'Y', customer1);
		pethelp.insertPet(pet1);
		
		ServicesHelper serviceshelp = new ServicesHelper();
		Services services1 = new Services("basic");
		//serviceshelp.insertServices(services1);
		
		AppointmentHelper appointmenthelp = new AppointmentHelper();
		//Appointment appointment1 = new Appointment(LocalDate.of(2018,  4,  11), customer1, pet1, services1, LocalTime.of(12, 30));
		//appointmenthelp.insertAppointment(appointment1);
		
	}
}
