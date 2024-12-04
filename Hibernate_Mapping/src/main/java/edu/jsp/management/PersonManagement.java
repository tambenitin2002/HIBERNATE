package edu.jsp.management;

import java.time.LocalDate;

import org.jsp.table.PassPort;
import org.jsp.table.Person;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonManagement {
	PassPort passport=new PassPort();
	Person person=new Person();
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
	EntityManager manager=factory.createEntityManager();
	
	public void addPerson(Person person) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		//call the persist method to save person and passport
		
		manager.persist(person);
		
		
		transaction.commit();
	}
	public void addPassport(PassPort passport, int person_id) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		//call the persist method to save person and passport
		Person person=manager.find(Person.class, person_id);
		if(person!=null) {
			manager.persist(passport);
			
			manager.merge(person);
		}
		
		
		
		
		transaction.commit();
	}
	

}
