package Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import controller.PetHelper;

import model.Pet;




public class AddPetTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PetHelper pethelp = new PetHelper();
		Pet pet1 = new Pet("Jim", 40.0, 'Y');
		pethelp.insertPet(pet1);
		
	}
}
