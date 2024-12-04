package org.jsp.Application;

import java.time.LocalDate;
import java.util.Scanner;

import org.jsp.table.PassPort;
import org.jsp.table.Person;

import edu.jsp.management.PersonManagement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonApplicaton {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
	    PersonManagement personmanagement=new PersonManagement();
	    
	    boolean flag=true;
	    while(flag) {
	    	System.out.println("Follow the following operations! \n 1. Add Person And Passport. \n 2. add passport \n 3. Remove the person and passport by id. \n 4. Close the application \n Enter the Your Choice:  ");
	    	int choice=sc.nextInt();
	    	
	    	switch (choice) {
			case 1:{
				Person person=new Person();
				System.out.println("Enter Person name: ");
				String name=sc.next();
				person.setName(name);
				personmanagement.addPerson(person);
				
				
				break;
			   }
			
			case 2:{
				PassPort passport=new PassPort();
				System.out.println("Enter the passport issue date: ");
				LocalDate date=LocalDate.parse(sc.next());
				passport.setIssueDate(date);
				
				
				break;
			}
			case 4:{
				   flag=false;
				
				break;
			   }
			default:
				break;
			}
	    	
	    }
		
	}

}
