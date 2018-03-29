package model;
/*
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="appointment")
public class MobileAppointment extends Appointment{
	@Column(name="start_time")
	private LocalTime arrival;
	@Column(name="end_time")
	private LocalTime departure;
	private String address;
	private int distance;
	private final double MOBILE_FEE = 20.00;
	@Column(name="app_cd")
	private final char type = 'M';
	
	public MobileAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MobileAppointment(Customer customer, Pet pet, Services services, LocalDate appointmentDate,
			LocalTime arrival, LocalTime departure, String address, int distance) {
		super(customer, pet, services, appointmentDate);
		this.arrival = arrival;
		this.departure = departure;
		this.address = address;
		
	}

	public MobileAppointment(Customer customer, Pet pet, Services services, LocalDate appointmentDate,
			LocalTime arrival) {
		super(customer, pet, services, appointmentDate);
		this.arrival = arrival;
		setDeparture();
	}

	public LocalTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}

	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture() {
		this.departure = arrival.plusMinutes(45);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}


	DecimalFormat df = new DecimalFormat("$,###,##0.00");
	@Override
	public String printReceipt() {
		// TODO Auto-generated method stub
		totalCost += MOBILE_FEE;
		return super.printReceipt() +  "\nDropoff Time: " + arrival + "\nPickup Time: " + departure + "\nTotalCost = " + (df.format(totalCost));
	}
	
	
	
}
*/
