package Test;

import controller.CustomerHelper;
import controller.PetHelper;
import model.Customer;
import model.Pet;

public class UpdatePet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetHelper pethelper = new PetHelper();
		Pet toEdit = pethelper.searchForPetById(3);
		toEdit.setName("Mia");
		pethelper.updatePet(toEdit);
	}

}
