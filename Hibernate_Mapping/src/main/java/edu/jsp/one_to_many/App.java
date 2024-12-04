package edu.jsp.one_to_many;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Books book1=new Books();
		book1.setName("Java");
		book1.setType("TextBook");
		
		Books book2=new Books();
		book2.setName("SQL");
		book2.setType("TextBook");
		
		
		List<Books> book=new ArrayList<Books>();
		book.add(book1);
		book.add(book2);
		
		Author author=new Author();
		author.setName("PQR");
		author.setEmail("email@gmail.com");
		author.setMobile(885656596);
		
		author.setBooks(book);
		manager.persist(book1);
		manager.persist(book2);
		manager.persist(author);
		
		manager.getTransaction().commit();
	}

}
