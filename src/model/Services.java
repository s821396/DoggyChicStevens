package model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="service")

public class Services {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int servicesID;
	@Column(name="plan_name")
	private String planName;
	@Column(name="description")
	private String description;
	@Column(name="base_cost")
	private double cost;
	@Transient
	private final String  BASIC_DESCRIPTION = "Wash, dry and nail trim";
	@Transient
	private final String PREMIUM_DESCRIPTION = "Wash, dry, nail trim, haircut";
	@Transient
	private final String SUPER_DESCRIPTION = "Wash, dry, nail trim, haircut, and furminator";
	@Transient
	private final double BASIC_PRICE = 30.00;
	@Transient
	private final double PREMIUM_PRICE = 40.00;
	@Transient
	private final double SUPER_PRICE = 50.00;
	@Transient
	private final int BASIC_ID = 1;
	@Transient
	private final int SUPER_ID = 3;
	@Transient
	private final int PREMIUM_ID = 2;
	
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Services(int servicesID, String planName, double cost) {
		super();
		this.servicesID = servicesID;
		this.setPlanName(planName);
		
	}

	public Services(String planName, String description, double cost) {
		super();
		this.planName = planName;
		this.description = description;
		this.cost = cost;
	}

	public Services(String planName) {
		super();
		this.setPlanName(planName);
		
	}

	public int getServicesID() {
		return servicesID;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
		if(planName.equalsIgnoreCase("basic")) {
			description = BASIC_DESCRIPTION;
			this.cost = BASIC_PRICE;
			this.servicesID = BASIC_ID;
		} else if(planName.equalsIgnoreCase("premium")) {
			description = PREMIUM_DESCRIPTION;
			this.cost = PREMIUM_PRICE;
			this.servicesID = PREMIUM_ID;
		} else if(planName.equalsIgnoreCase("super")) {
			description = SUPER_DESCRIPTION;
			this.cost = SUPER_PRICE;
			this.servicesID = SUPER_ID;
		}
	}

	public double getCost() {
		return cost;
	}

	public String getDescription() {
		return description;
	}
	@Transient
	DecimalFormat df = new DecimalFormat("$,###,##0.00");
	
	
	
	@Override
	public String toString() {
		return "Services [servicesID=" + servicesID + ", planName=" + planName + ", description=" + description
				+ ", cost=" + cost + "]";
	}

	public String viewPlanDetails() {
		description = "Available Plans: " + "\nBasic - " + BASIC_DESCRIPTION + "\nPremium - " + PREMIUM_DESCRIPTION + "\nSuper - " + SUPER_DESCRIPTION;
    	return description;
    }

	public String printDetail() {
		return "******** " + "Service Information: ********" + "\nService ID: " + servicesID + "\nPlan Name: " + planName + "\nCost of Service: " + (cost) + "\nDescription of Service: "	+ description;	}
}
