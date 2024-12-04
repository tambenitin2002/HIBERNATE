package org.jsp.table;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateIssueDateByPersonId {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Person person=manager.find(Person.class, 4);
		System.out.println("Before : "+person);
		 if(person != null) {
			 PassPort pass=new PassPort();
			 if(pass != null) {
				 pass.setIssueDate(LocalDate.parse("2023-12-10"));
				 Person updatedPerson=manager.merge(person);
				 System.out.println("After: "+updatedPerson);
			 }else {
				 System.err.println("No Passport found....");
			 }
			 
		 }else {
			 System.err.println("No Data found .... ");
		 }
		
		
		manager.getTransaction().commit();

	}

}
