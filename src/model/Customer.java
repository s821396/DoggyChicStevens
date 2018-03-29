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
	@Column(name="id")
	private int customterID;
	@Column(name="f_name")
	private String customerFirstName;
	@Column(name="l_name")
	private String customerLastName;
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
	
	
	public Customer(int customterID) {
		super();
		this.customterID = customterID;
	}


	public Customer(String customerFirstName, String customerLastName, String streetAddress, String city, String state,
			String zip, String phoneNumber) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	
	public int getCustomterID() {
		return customterID;
	}


	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}


	public String getCustomerLastName() {
		return customerLastName;
	}


	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String printDetail() {
		return "******** " + "Customer Information: ********" + "\nCustomerId: " + customterID + "\nCustomer Name: " + customerFirstName +  " " + customerLastName + "\nPhone Number: "
				+ phoneNumber + "\nCustomer Address: " + streetAddress + "," + state + "  " + zip;
	}
		
	@Override
	public String toString() {
		return "Customer [customterID=" + customterID + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + "]";
	}
}
