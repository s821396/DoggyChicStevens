package Test;

import java.time.LocalDate;

import controller.AppointmentHelper;
import controller.CustomerHelper;
import model.Appointment;
import model.Customer;

public class UpdateCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerHelper custhelper = new CustomerHelper();
		Customer toEdit = custhelper.searchForCustomerById(3);
		toEdit.setStreetAddress("7777 High St.");
		custhelper.updateCustomer(toEdit);
	}

}
