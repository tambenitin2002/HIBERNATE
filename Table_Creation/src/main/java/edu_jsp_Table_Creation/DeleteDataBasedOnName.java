package edu_jsp_Table_Creation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DeleteDataBasedOnName {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		String query="DELETE FROM Employee where ename='Aniket'";
		Query jpql=manager.createQuery(query);
		int record=jpql.executeUpdate();
		if(record!=0) {
			System.out.println("Record Deleted...");
		}else {
			System.err.println("No Data Found...");
		}
		transaction.commit();
	}

}
