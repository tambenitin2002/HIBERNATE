package edu.jsp.one_to_many;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
		EntityManager manager=factory.createEntityManager();
		
		Author author=manager.find(Author.class, 101);
		
		List<Books> books=author.getBooks();
		for(Books book:books) {
			System.out.println("Name = "+book.getName());
		}
	}

}
