package edu_jsp_Table_Creation;
import jakarta.persistence.*;
public class Employee_Table {

	public static void main(String[] args) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("hibernate");
		
		EntityManager manager=factory.createEntityManager();

	}

}
