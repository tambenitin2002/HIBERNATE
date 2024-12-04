package edu.jsp.primary_key;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AddressApp {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hib");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		Address address=new Address();
		
		address.setArea("Hadapsar");
		address.setCity("pune");
		address.setPincode(422412);
		address.setState("Maharashtra");
		
		
		manager.persist(address);
		
		transaction.commit();

	}

}
	