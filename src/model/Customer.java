package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="f_name")
	private String firstName;
	@Column(name="l_name")
	private String lastName;
	@Column(name="street_add")
	private String streetAddress;
	private String city;
	private String state;
	@Column(name="zip_code")
	private String zip;
	@Column(name="phone")
	private String phoneNumber;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(int id) {
		super();
		this.id = id;
	}


	public Customer(String firstName, String lastName, String streetAddress, String city, String state,
			String zip, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		
	}

	
	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}



	public String printDetail() {
		return "******** " + "Customer Information: ********" + "\nCustomerId: " + id + "\nCustomer Name: " + firstName +  " " + lastName + "\nPhone Number: "
				+ phoneNumber + "\nCustomer Address: " + streetAddress + "," + state + "  " + zip;
	}
		
	@Override
	public String toString() {
		return "Customer [customterID=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + "]";
	}
}
