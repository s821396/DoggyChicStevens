package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class Pet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private int petID;
	@Column(name="pet_name")
	private String name;
	private double weight;
	@Column(name="vaccinations")
	private char hasShots;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(int petID) {
		super();
		this.petID = petID;
	}

	public Pet(int petID, String name, double weight, char hasShots) {
		super();
		this.petID = petID;
		this.name = name;
		this.weight = weight;
		this.hasShots = hasShots;
	}

	public Pet(String name, double weight, char hasShots) {
		super();
		this.name = name;
		this.weight = weight;
		this.hasShots = hasShots;
	}

	

	public Pet(String name, double weight, char hasShots, Customer customer) {
		super();
		this.name = name;
		this.weight = weight;
		this.hasShots = hasShots;
		this.customer = customer;
	}

	public int getPetID() {
		return petID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public char getHasShots() {
		return hasShots;
	}

	public void setHasShots(char hasShots) {
		this.hasShots = hasShots;
	}
	
			
	public String printDetail(char hasShots) {
		String shots;
		if (hasShots == 'Y') {
			shots = "Yes";
		}else {
			shots = "No";
		}
			
		return "******** "+ "Pet Information: ********" +"\nPet id: " + petID + "\nName:  " + name + "\nWeight: " + weight + "\nShots up to date: " + shots;
	}
	
	@Override
	public String toString() {
		return "***********************" + "\nPet Information:" + "\nPet ID=" + petID + "\nPet Name = " + name + "\nPet Weight=" + weight + " lbs" +  "\nDoes Pet have Shots = " + hasShots;
	}
	
}
