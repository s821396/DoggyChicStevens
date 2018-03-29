package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int appointment_id;
	@Column(name="Appointment_date")
	private LocalDate appointmentDate;
	@Column(name="start_time")
	private LocalTime pickup;
	@Column(name="end_time")
	private LocalTime dropoff;
	@Column(name="total_cost")
	protected double totalCost;
	@ManyToOne
	@JoinColumn(name= "pet_id")
	private Pet pet;
	@ManyToOne
	@JoinColumn(name= "service_id")
	private Services services;
	
	@Transient
	private Customer customer;
	@Transient
	protected double upcharge;
	
	
	@Transient
	private final double WEIGHT1 = 25;
	@Transient
	private final double WEIGHT2 = 50;
	@Transient
	private final double WEIGHT3 = 51;
	@Transient
	private final double MED_CHARGE = 10;
	@Transient
	private final double LRG_CHARGE = 20;
	@Transient
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
	@Transient
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
	
	
		
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Appointment(int appointment_id) {
		super();
		this.appointment_id = appointment_id;
	}



	public Appointment(Customer customer, Pet pet, Services services, LocalDate appointmentDate) {
		super();
		this.customer = customer;
		this.pet = pet;
		this.services = services;
		this.appointmentDate = appointmentDate;
		setTotalCost();
	}


	public Appointment(Customer customer, Pet pet, Services services,
			LocalDate appointmentDate, LocalTime dropoff) {
		super();
		this.appointmentDate = appointmentDate;
		this.customer = customer;
		this.pet = pet;
		this.services = services;
		setTotalCost();
		this.dropoff = dropoff;
		setPickup(dropoff);
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public String getAppointmentDate() {
		return dateFormat.format(appointmentDate);
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost() {
		this.totalCost = services.getCost() + calculateUpcharge(pet.getWeight());
		
	}
	
	public String getUpcharge() {
		this.upcharge = calculateUpcharge(pet.getWeight());
		return df.format(upcharge);
	}
	
	public LocalTime getPickup() {
		return pickup;
	}

	public void setPickup(LocalTime pickup) {
		this.pickup = dropoff.plusMinutes(45);
	}

	public LocalTime getDropoff() {
		return dropoff;
	}

	public void setDropoff(LocalTime dropoff) {
		this.dropoff = dropoff;
	}
	
	public double calculateUpcharge(double weight) {
		double upcharge = 0;
		if(weight >WEIGHT1 && weight < WEIGHT3) {
			upcharge = MED_CHARGE;
		} else if(weight > WEIGHT2) {
			upcharge = LRG_CHARGE;
		}
		return upcharge;
	}
    @Transient
	DecimalFormat df = new DecimalFormat("$,###,##0.00");
	
	/*public String printReceipt() {
		return customer.printDetail() + "\n" + pet.printDetail(pet.isHasShots()) + "\n" + services.printDetail() + "\nAppointment Date: " + appointmentDate;
	}*/
    
    
	public String printReceipt() {
		DecimalFormat df = new DecimalFormat("$##0.00");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		return "----Customer Info----" + customer.printDetail() + "\n\n----Pet Info----" + pet.printDetail(pet.getHasShots()) + "\nUpcharge for Size: " + df.format(upcharge) + "\n\n----Grooming Package----" + services.printDetail() + "\n\nAppointment Date: " + dateFormat.format(appointmentDate) + "\nArrival: " + timeFormat.format(dropoff) + "\nDeparture: " + timeFormat.format(pickup);
	}
	
	
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", appointmentDate=" + appointmentDate + ", pickup="
				+ pickup + ", dropoff=" + dropoff + ", totalCost=" + totalCost + ", pet=" + pet + ", services="
				+ services + ", customer=" + customer + ", upcharge=" + upcharge + ", WEIGHT1=" + WEIGHT1 + ", WEIGHT2="
				+ WEIGHT2 + ", WEIGHT3=" + WEIGHT3 + ", MED_CHARGE=" + MED_CHARGE + ", LRG_CHARGE=" + LRG_CHARGE
				+ ", dateFormat=" + dateFormat + ", timeFormat=" + timeFormat + ", df=" + df + "]";
	}



	public String printSecondReceipt() {
		DecimalFormat df = new DecimalFormat("$##0.00");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		return "\n\n----Pet Info----" + pet.printDetail(pet.getHasShots()) + "\nUpcharge for Size: " + df.format(upcharge) + "\n\n----Grooming Package----" + services.printDetail() + "\n\nAppointment Date: " + dateFormat.format(appointmentDate) + "\nArrival: " + timeFormat.format(dropoff) + "\nDeparture: " + timeFormat.format(pickup);
	}
	
	
	
}
