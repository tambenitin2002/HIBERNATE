package edu_jsp_Table_Creation;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AddEmployee {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		 Employee emp=new Employee();
		 emp.setEmpId(2);
		 emp.setEname("xyz");
		 emp.setDeptNo(10);
		 emp.setSalary(30000);
		 String date="2002-03-25";
		 LocalDate dob=LocalDate.parse(date);
		 emp.setDob(dob);
		 manager.persist(emp);
		transaction.commit();
		
		
	}

}
