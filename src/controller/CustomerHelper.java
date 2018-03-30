package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Appointment;
import model.Customer;
import model.Pet;

public class CustomerHelper {
EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DoggyChicStevens");
	
	public void insertCustomer(Customer toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void deleteCustomer(Customer toDelete) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Customer find = em.find(Customer.class, toDelete.getId());
		em.remove(find);
		em.getTransaction().commit();
		em.close();
	}
	
	public Customer searchForCustomerById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Customer foundItem = em.find(Customer.class, idToEdit);
		em.close();
		return foundItem;
	}
	

	public List<Customer> showAllCustomers() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Customer> allResults = em.createQuery("select ch from Customer ch", Customer.class);
		List<Customer> allCustomers = allResults.getResultList();
		em.close();
		return allCustomers;
		
	}
	
	public List<Customer> searchForCustomerByName(String lastName) {
		// TODO Auto-generated method stub
		System.out.println("CustomerHelper LastName = " + lastName);
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Customer> typedQuery = em.createQuery("select cust from Customer cust where cust.lastName = :selectedLastName", Customer.class);
		typedQuery.setParameter("selectedLastName", lastName);
		List<Customer> allCustomers = typedQuery.getResultList();
		em.close();
		return allCustomers;
	}
	
	public void updateCustomer(Customer toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public void cleanUp() {
		emfactory.close();
	}

	public Customer searchForCustomerByPet(Pet pet) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Customer> result = em.createQuery("select c from Customer c INNER JOIN Pet p where p.customer = c and p = :selectedPetId", Customer.class);
		result.setParameter("selectedPetId", pet);
		Customer customer = result.getSingleResult();
		em.close();
		return customer;
	}
}
