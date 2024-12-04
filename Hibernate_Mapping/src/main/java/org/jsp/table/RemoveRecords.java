package org.jsp.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RemoveRecords {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		
		Person person=manager.find(Person.class, 1);
		if(person != null) {
			manager.remove(person);
			if(person.getPassport() !=null) {
				manager.remove(person.getPassport());
				System.out.println("Passport and Person data Deleted");
			}else {
				System.err.println("passport not found...");
			}
		}else {
			System.err.println("Data is Not Found! ");
		}
		
		
		manager.getTransaction().commit();

	}

}
