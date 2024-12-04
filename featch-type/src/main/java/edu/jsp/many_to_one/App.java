package edu.jsp.many_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		 EntityManagerFactory factory =Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();	
		
		Employees employee=manager.find(Employees.class, 1);

	}

}
