package edu_jsp_Table_Creation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RemoveEmployee {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		// first find record - which needs to delete
		  Employee employee=manager.find(Employee.class, 1);
		  //delete
		  if(employee!=null) {
			  manager.remove(employee);
			  System.out.println("Record Deleted...");
		  }else {
			  System.err.println("No Data Found");
		  }
		transaction.commit();
	}

}
