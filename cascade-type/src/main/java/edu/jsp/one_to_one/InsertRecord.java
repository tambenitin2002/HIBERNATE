package edu.jsp.one_to_one;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InsertRecord {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		PassPort passport=new PassPort();
		passport.setIssueDate(LocalDate.parse("2024-03-06"));
		Person person=new Person();
		person.setName("xyz");
		person.setPassport(passport);
		
		manager.persist(person);
		
		manager.getTransaction().commit();

	}

}
