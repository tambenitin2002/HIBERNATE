package org.jsp.table;

import java.time.LocalDate;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class addPassport {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PassPort passport=new PassPort();
		Person person=new Person();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		System.out.println("Enetr the passport isssue date: ");
		String tempDate=sc.next()	;
		LocalDate date=LocalDate.parse(tempDate);
		
		passport.setIssueDate(date);
		
		System.out.println(" Enter the person id : ");
		person=manager.find(Person.class, sc.nextInt());
		if(person != null ) {
			//add passport into person
			person.setPassport(passport);
			//save passport
			manager.persist(passport);
			//update person
			manager.merge(person);
		}
		
		transaction.commit();

	}

}
