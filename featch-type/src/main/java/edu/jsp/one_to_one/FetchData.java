package edu.jsp.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchData {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		
		Person person=manager.find(Person.class, 1);
		
		PassPort passport=person.getPassport();
		System.out.println("Passport Id : "+passport.getId());
		System.out.println("Issued date: "+passport.getIssueDate());

	}

}
