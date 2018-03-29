package Test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import controller.AppointmentHelper;

import model.Appointment;



public class UpdateAppointment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppointmentHelper apphelper = new AppointmentHelper();
		Appointment toEdit = apphelper.searchForAppointmentById(5);
		toEdit.setAppointmentDate(LocalDate.of(2017,  4,  11));
		apphelper.updateAppointment(toEdit);
	}

}
