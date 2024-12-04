package edu.jsp.one_to_many;

import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		AuthorBookManagement management = new AuthorBookManagement();
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		while (flag) {
			System.out.println("Enter 1 to add Author");
			System.out.println("Enter 2 to add Book");
			System.out.println("Enter 3 to get Author by mobile");
			System.out.println("Enter 4 to get Author by ID");
			System.out.println("Enter 5 to get all Authors sorted by name");
			System.out.println("Enter 6 to get Book by ID");
			System.out.println("Enter 7 to get all Books by Author's name");
			System.out.println("Enter 8 to get number of Books written by an Author");
			System.out.println("Enter 9 to remove Author by email");
			System.out.println("Enter 10 to update Author by ID");
			System.out.println("Enter 11 to update Book by ID");
			System.out.println("Enter 12 to Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				Author author = new Author();
				System.out.println("Enter Author's Email: ");
				author.setEmail(sc.next());
				System.out.println("Enter Author's Name: ");
				author.setName(sc.next());
				System.out.println("Enter Author's Mobile: ");
				author.setMobile(sc.nextLong());
				management.addAuthor(author);
				break;
			}
			case 2: {
				Books books = new Books();
				System.out.println("Enter Book Name: ");
				books.setName(sc.next());
				System.out.println("Enter Book Type: ");
				books.setType(sc.next());
				System.out.println("Enter Author ID to associate with this Book: ");
				management.addBook(books, sc.nextInt());
				break;
			}
			case 3: {
				System.out.println("Enter Author's Mobile: ");
				Author author = management.getAuthirByMobile(sc.nextLong());
				if (author != null) {
					System.out.println(author);
				} else {
					System.out.println("Author not found.");
				}
				break;
			}
			case 4: {
				System.out.println("Enter Author's ID: ");
				Author author = management.getAuthorSortById(sc.nextInt());
				if (author != null) {
					System.out.println(author);
				} else {
					System.out.println("Author not found.");
				}
				break;
			}
			case 5: {
				List<Author> authors = management.getAllAuthorByName();
				for (Author author : authors) {
					System.out.println(author);
				}
				break;
			}
			case 6: {
				System.out.println("Enter Book's ID: ");
				Books book = management.getBookById(sc.nextInt());
				if (book != null) {
					System.out.println(book);
				} else {
					System.out.println("Book not found.");
				}
				break;
			}
			case 7: {
				System.out.println("Enter Author's Name: ");
				List<Books> books = management.getAllBookByName(sc.next());
				for (Books book : books) {
					System.out.println(book);
				}
				break;
			}
			case 8: {
				System.out.println("Enter Author's ID: ");
				int count = management.getNoOfBookWrittenByAuthor(sc.nextInt());
				System.out.println("Number of books written: " + count);
				break;
			}
			case 9: {
				System.out.println("Enter Author's Email to remove: ");
				boolean removed = management.removeAuthorByEmail(sc.next());
				if (removed) {
					System.out.println("Author removed successfully.");
				} else {
					System.out.println("Failed to remove Author.");
				}
				break;
			}
			case 10: {
				System.out.println("Enter Author's ID to update: ");
				int authorId = sc.nextInt();
				Author author = new Author();
				System.out.println("Enter new Author's Name: ");
				author.setName(sc.next());
				System.out.println("Enter new Author's Email: ");
				author.setEmail(sc.next());
				System.out.println("Enter new Author's Mobile: ");
				author.setMobile(sc.nextLong());
				Author updatedAuthor = management.updateAuthorById(author, authorId);
				if (updatedAuthor != null) {
					System.out.println("Author updated successfully: " + updatedAuthor);
				} else {
					System.out.println("Failed to update Author.");
				}
				break;
			}
			case 11: {
				System.out.println("Enter Book's ID to update: ");
				int bookId = sc.nextInt();
				Books book = new Books();
				System.out.println("Enter new Book's Name: ");
				book.setName(sc.next());
				System.out.println("Enter new Book's Type: ");
				book.setType(sc.next());
				Books updatedBook = management.updateBookById(book, bookId);
				if (updatedBook != null) {
					System.out.println("Book updated successfully: " + updatedBook);
				} else {
					System.out.println("Failed to update Book.");
				}
				break;
			}
			case 12: {
				flag = false;
				System.out.println("Exiting Application.");
				break;
			}
			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}
		}
		sc.close();
	}
}
