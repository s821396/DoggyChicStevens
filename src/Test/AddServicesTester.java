package Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import controller.CustomerHelper;
import controller.PetHelper;
import controller.ServicesHelper;
import model.Customer;
import model.Pet;
import model.Services;




public class AddServicesTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServicesHelper serviceshelp = new ServicesHelper();
		Services services1 = new Services("basic");
		serviceshelp.insertServices(services1);
		
		/*
		InstructorHelper instructorhelp = new InstructorHelper();
		Instructor Instructor2 = (Instructor) instructorhelp.searchForInstructorById(3);
		instructorhelp.deleteInstructor(Instructor2);
		}
		*/
	}
}
