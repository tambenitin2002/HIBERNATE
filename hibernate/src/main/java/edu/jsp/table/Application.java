package edu.jsp.table;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Application {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hib");
		EntityManager manager=factory.createEntityManager();
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		Customer customer=new Customer();
		customer.setId(1);
		customer.setFirstName("Nitin");
		customer.setLastName("Tambe");
		customer.setContact(548566255);
		customer.setEmail("tambe@gmail.com");
		customer.setPassword("pass122");
		customer.setDob(LocalDate.parse("2002-03-25"));
		
		manager.persist(customer);
		
		transaction.commit();
	}

}
