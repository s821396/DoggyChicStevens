package Test;

import controller.CustomerHelper;
import controller.PetHelper;
import model.Customer;
import model.Pet;

public class DeleteCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerHelper custhelper = new CustomerHelper();
		Customer toDelete = new Customer(1);
		custhelper.deleteCustomer(toDelete);
		System.out.println(custhelper.showAllCustomers());
	}

}
