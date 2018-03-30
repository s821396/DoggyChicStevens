package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Appointment;
import model.Customer;
import model.Pet;



public class AppointmentHelper {
EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DoggyChicStevens");
	
	public void insertAppointment(Appointment toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void deleteAppointment(Appointment toDelete) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Appointment find = em.find(Appointment.class, toDelete.getAppointment_id());
		em.remove(find);
		em.getTransaction().commit();
		em.close();
	}
	
	public Appointment searchForAppointmentById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Appointment foundAppointment = em.find(Appointment.class, idToEdit);
		em.close();
		return foundAppointment;
	}

	public List<Appointment> showAllAppointments() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Appointment> allResults = em.createQuery("select app from Appointment app", Appointment.class);
		List<Appointment> allAppointments = allResults.getResultList();
		em.close();
		return allAppointments;
		
	}
	public void updateAppointment(Appointment toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	public List<Appointment> searchForAppointmentByCustomerAndPet(String lastName, String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		CustomerHelper ch = new CustomerHelper();
		List<Customer> toFind = ch.searchForCustomerByName(lastName);
		
		PetHelper ph = new PetHelper();
		List<Pet> petList = ph.searchForPetByCustomer(toFind.get(0));
		
	    TypedQuery<Appointment> allResults = em.createQuery("select a from Appointment a INNER JOIN Pet p, Customer c where a.pet = p and p = :selectedPet and p.customer = c and c = :selectedCustomerName", Appointment.class);
		allResults.setParameter("selectedPet", petList.get(0));
		allResults.setParameter("selectedCustomerName", toFind.get(0));
		List<Appointment> allAppointments = allResults.getResultList();
		em.close();
		return allAppointments;
	}
}
