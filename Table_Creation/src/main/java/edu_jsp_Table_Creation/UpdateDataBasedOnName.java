package edu_jsp_Table_Creation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UpdateDataBasedOnName {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		String query=" UPDATE Employee set salary=3000 where ename='Guru'";
		Query jpql=manager.createQuery(query);
		int update=jpql.executeUpdate();
		
		if(update!=0) {
			System.out.println("Record Update...");
		}else {
			System.err.println("No Data Found...");
		}
		transaction.commit();
	}

}
