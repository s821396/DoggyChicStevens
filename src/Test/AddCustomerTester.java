package Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import controller.CustomerHelper;
import controller.PetHelper;
import model.Customer;
import model.Pet;




public class AddCustomerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerHelper customerhelp = new CustomerHelper();
		Customer customer1 = new Customer( "Scott", "Stevens", "7480 SW 19th St",  "Ankeny", "IA",  "50023" ,"5159751111");
		customerhelp.insertCustomer(customer1);
		
		/*
		InstructorHelper instructorhelp = new InstructorHelper();
		Instructor Instructor2 = (Instructor) instructorhelp.searchForInstructorById(3);
		instructorhelp.deleteInstructor(Instructor2);
		}
		*/
	}
}
