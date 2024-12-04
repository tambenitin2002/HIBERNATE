package edu_jsp_Table_Creation;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FetchRecordUsingCharacter {

	
		public static void main(String[] args) {
			  EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
			  EntityManager manager=factory.createEntityManager();
			  EntityTransaction transaction=manager.getTransaction();
			  transaction.begin();
			  String query ="SELECT emp FROM Employee emp WHERE ename like concat('%'+?1,'%')";
			  Query jpql=manager.createQuery(query);
			  Scanner sc=new Scanner(System.in);
			  System.out.println("Enter the search String");
			  jpql.setParameter(1, sc.next());
			  List<Employee> employees=jpql.getResultList();
			  
			  if(employees.isEmpty()) {
				  System.err.println("No Data Found");
			  }else {
				 for(Employee e1: employees) {
					 System.out.println(e1);
					 System.out.println("--------------------------------------------------------------------------");
				 }
			  }
			  transaction.commit();
			}

	}


