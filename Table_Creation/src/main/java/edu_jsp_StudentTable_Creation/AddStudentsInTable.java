package edu_jsp_StudentTable_Creation;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AddStudentsInTable {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		Student stud=new Student();
		stud.setSid(2);
		stud.setFname("Nitin");
		stud.setLname("Tambe");
		stud.setContact(5462655);
		stud.setEmail("tambenitin2002@gmail.com");
		stud.setCity("Pune");
		String date="2002-03-25";
		LocalDate dob=LocalDate.parse(date);
	    stud.setDob(dob);
		transaction.commit();
	}

}
