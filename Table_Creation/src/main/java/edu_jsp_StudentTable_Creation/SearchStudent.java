package edu_jsp_StudentTable_Creation;
import java.util.Scanner;

import jakarta.persistence.*;

public class SearchStudent {

	    public static void main(String[] args) {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
	        EntityManager manager = factory.createEntityManager();
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter Student ID to Search: ");
	        int searchId = scanner.nextInt();
	        Student stud = manager.find(Student.class, searchId);
	        if (stud != null) {
	            System.out.println(stud);
	        } else {
	            System.err.println("Student Not Found");
	        }
	    }
	}


