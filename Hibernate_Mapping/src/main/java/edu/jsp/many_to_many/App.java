package edu.jsp.many_to_many;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App  {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		Subject sub1=new Subject();
		sub1.setName("java");
		Subject sub2=new Subject();
		sub2.setName("SQL");
		Subject sub3=new Subject();
		sub3.setName("Web Tech");
		
		
		List<Subject> listforStudent1=new ArrayList<Subject>();
		listforStudent1.add(sub3);
		listforStudent1.add(sub2);
		listforStudent1.add(sub1);
		
		Student s1=new Student();
		
		s1.setName("xyz");
		s1.setPercentage(98);
		s1.setSubjects(listforStudent1);
		
		manager.persist(s1);
		transaction.commit();

	}

}
