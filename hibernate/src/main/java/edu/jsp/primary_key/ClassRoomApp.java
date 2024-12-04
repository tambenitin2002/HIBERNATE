package edu.jsp.primary_key;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClassRoomApp {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hib");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		ClassRoom classroom=new ClassRoom();
		classroom.setCapacity(50);
		classroom.setFlower(8);
		classroom.setSubject("Hibernate");
		
		
		manager.persist(classroom);
		
		transaction.commit();
	}

	

}
