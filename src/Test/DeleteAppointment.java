package Test;

import controller.AppointmentHelper;
import model.Appointment;


public class DeleteAppointment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppointmentHelper apphelper = new AppointmentHelper();
		Appointment toDelete = new Appointment(1);
		apphelper.deleteAppointment(toDelete);
		System.out.println(apphelper.showAllAppointments());
	}
}
