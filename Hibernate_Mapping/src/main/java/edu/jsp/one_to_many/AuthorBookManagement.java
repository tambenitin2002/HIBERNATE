package edu.jsp.one_to_many;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AuthorBookManagement {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni-directional");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void addAuthor(Author author) {
		transaction.begin();
		manager.persist(author);
		transaction.commit();
	}

	public void addBook(Books books, int authorId) {
		Author author = manager.find(Author.class, authorId);
		if (author != null) {
			List<Books> b = new ArrayList<Books>();
			b.add(books);
			author.setBooks(b);

			transaction.begin();
			manager.persist(books);
			manager.merge(author);
			transaction.commit();

			System.out.println("Book Added Successfully!");
		} else {
			System.out.println("Record Not Found!");
		}
	}

	public Author getAuthirByMobile(long mobile) {
		String query = "SELECT a FROM Author a WHERE Mobile=:mob";
		Query jpql = manager.createQuery(query);
		jpql.setParameter("mob", mobile);
		try {
			Author author = (Author) jpql.getSingleResult();
			return author;
		} catch (Exception e) {
			return null;
		}
	}

	// New methods

	public Author getAuthorSortById(int id) {
		Author author = manager.find(Author.class, id);
		return author;
	}

	public List<Author> getAllAuthorByName() {
		String query = "SELECT a FROM Author a ORDER BY a.name";
		Query jpql = manager.createQuery(query);
		List<Author> authors = jpql.getResultList();
		return authors;
	}

	public Books getBookById(int id) {
		Books book = manager.find(Books.class, id);
		return book;
	}

	public List<Books> getAllBookByName(String authorName) {
		String query = "SELECT b FROM Books b JOIN b.author a WHERE a.name=:name";
		Query jpql = manager.createQuery(query);
		jpql.setParameter("name", authorName);
		List<Books> books = jpql.getResultList();
		return books;
	}

	public int getNoOfBookWrittenByAuthor(int authorId) {
		Author author = manager.find(Author.class, authorId);
		if (author != null && author.getBooks() != null) {
			return author.getBooks().size();
		}
		return 0;
	}

	public boolean removeAuthorByEmail(String email) {
		String query = "SELECT a FROM Author a WHERE a.email=:email";
		Query jpql = manager.createQuery(query);
		jpql.setParameter("email", email);
		try {
			Author author = (Author) jpql.getSingleResult();
			if (author != null) {
				transaction.begin();
				manager.remove(author);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public Author updateAuthorById(Author updatedAuthor, int authorId) {
		Author author = manager.find(Author.class, authorId);
		if (author != null) {
			author.setName(updatedAuthor.getName());
			author.setEmail(updatedAuthor.getEmail());
			author.setMobile(updatedAuthor.getMobile());

			transaction.begin();
			manager.merge(author);
			transaction.commit();
			return author;
		}
		return null;
	}

	public Books updateBookById(Books updatedBook, int bookId) {
		Books book = manager.find(Books.class, bookId);
		if (book != null) {
			book.setName(updatedBook.getName());
			book.setType(updatedBook.getType());

			transaction.begin();
			manager.merge(book);
			transaction.commit();
			return book;
		}
		return null;
	}
}
