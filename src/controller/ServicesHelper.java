package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Appointment;
import model.Services;

public class ServicesHelper {
EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DoggyChicStevens");
	
	public void insertServices(Services toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void deleteServices(Services toDelete) {
		// TODO Auto-generated method stub
		int varId = toDelete.getServicesID();
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Services> typedQuery = em.createQuery("select sh from services sh where inst.id = :selectedId", Services.class);
		typedQuery.setParameter("selectedId", varId);
		typedQuery.setMaxResults(1);
		Services result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Services searchForServicesById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Services foundItem = em.find(Services.class, idToEdit);
		em.close();
		return foundItem;
	}

	public void cleanUp() {
		emfactory.close();
	}

	public Services searchForServiceByAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Services> result = em.createQuery("select s from Services s INNER JOIN Appointment a where a.services = s and a = :selectedAppointmentId", Services.class);
		result.setParameter("selectedAppointmentId", appointment);
		Services service = result.getSingleResult();
		em.close();
		return service;
	}
}
