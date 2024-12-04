package edu.jsp.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class StudentApplication {
	
	public static void main(String[] args) {
		
	
	EntityManagerFactory factory =Persistence.createEntityManagerFactory("hib");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction= manager.getTransaction();
	transaction.begin();
	
	
	transaction.commit();
	
	}

}
