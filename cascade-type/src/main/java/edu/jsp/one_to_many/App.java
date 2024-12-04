package edu.jsp.one_to_many;

import java.util.List;

import edu.jsp.one_to_one.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {


	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		   Author author=manager.find(Author.class, 101);
		   if(author!=null) {
			   manager.remove(author);
		   }else {
			   System.out.println("No data Found...");
		   }
		manager.getTransaction().commit();
	}

}
