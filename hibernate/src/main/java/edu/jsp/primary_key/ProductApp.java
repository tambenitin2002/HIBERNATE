package edu.jsp.primary_key;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductApp {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hib");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		Product product=new Product();
		product.setProductName("Mobile");
		product.setPrice(100000);
		
		manager.persist(product);
		
		transaction.commit();
	}

}
