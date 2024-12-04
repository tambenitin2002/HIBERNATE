package edu_jsp_Table_Creation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SearchEmployee {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		Employee emp=manager.find(Employee.class, 1);
		System.out.println(emp);

	}

}
