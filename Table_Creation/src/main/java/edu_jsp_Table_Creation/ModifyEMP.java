package edu_jsp_Table_Creation;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class ModifyEMP {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		Employee employee=manager.find(Employee.class, 2);
		System.out.println("Before: "+employee);
		if(employee!=null) {
			employee.setDeptNo(30);
			employee.setEname("Aniket");
			employee.setSalary(5000000);
			employee.setDob(LocalDate.parse("2002-09-01"));
			Employee modifiedEmp=manager.merge(employee);
			System.out.println("after: "+modifiedEmp);
		}else {
			System.out.println("no data found");
		}
		transaction.commit();
		
	}

}
