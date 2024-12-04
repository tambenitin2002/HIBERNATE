package edu.jsp.one_to_one;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RemoveRecord {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		   Person person=manager.find(Person.class, 1);
		   if(person!=null) {
			   manager.remove(person);
		   }else {
			   System.out.println("No data Found...");
		   }
		manager.getTransaction().commit();
	}

}
