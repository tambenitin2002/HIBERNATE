package edu.jsp.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FetchTheMobileNumberUsingAuther {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		
		String query= "SELECT  as FROM Authod as WHERE mobile=?1 ";
		
		Query jpql=manager.createQuery(query);
		
		
		manager.getTransaction().commit();

	}

}
