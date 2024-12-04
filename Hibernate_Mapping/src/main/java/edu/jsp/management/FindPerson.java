package edu.jsp.management;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.jsp.table.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FindPerson {
	static EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
	static EntityManager manager=factory.createEntityManager();
	public static List<Person> getPersonByIssueDateBetween(LocalDate start , LocalDate end){
		Person person=new Person();
		String query="SELECT p FROM Person p WHERE passport.issueDate between ?1 and ?2";
		Query jpql=manager.createQuery(query);
		jpql.setParameter(1, start);
		jpql.setParameter(2, end);
		
		List<Person> persons=jpql.getResultList()	;
		return persons;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the starting date: ");
		LocalDate start=LocalDate.parse(sc.next());
		System.out.println("Enter the endiing date: ");
		LocalDate end=LocalDate.parse(sc.next());
		List<Person> persons=getPersonByIssueDateBetween(start, end);
		if(persons.isEmpty()) {
			System.out.println("No Date found...");
		}else {
			for(Person person:persons){
				System.out.println(person);
				
			}
		}
		

	}

}
