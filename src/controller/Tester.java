package controller;

import java.util.List;

import model.Appointment;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppointmentHelper ah = new AppointmentHelper();
		List<Appointment> applist = ah.searchForAppointmentByCustomerAndPet("Stevens", "Jimmy");
		
		
		System.out.println("values in app list");
		for(Appointment a : applist) {
			System.out.println("========================");
			System.out.println(a.toString());
		}
	}

}
