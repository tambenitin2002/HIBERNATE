package edu_jsp_StudentTable_Creation;
import java.util.Scanner;

import jakarta.persistence.*;

public class RemoveStudent {

	

	    public static void main(String[] args) {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
	        EntityManager manager = factory.createEntityManager();
	        EntityTransaction transaction = manager.getTransaction();
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter Student ID to Remove: ");
	        int removeId = scanner.nextInt();

	        transaction.begin();
	        Student stud = manager.find(Student.class, removeId);
	        if (stud != null) {
	            manager.remove(stud);
	            System.out.println("Student Removed Successfully");
	        } else {
	            System.err.println("Student Not Found");
	        }
	        transaction.commit();
	    }
	}


