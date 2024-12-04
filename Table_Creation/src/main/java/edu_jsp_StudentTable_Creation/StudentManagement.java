package edu_jsp_StudentTable_Creation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options to the user
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Students");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Remove Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add students
                    System.out.print("How many students do you want to add? ");
                    int numStudents = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    transaction.begin();
                    for (int i = 1; i <= numStudents; i++) {
                        Student stud = new Student();
                        System.out.println("\nAdding Student " + i + ":");
                        System.out.print("Enter Student ID: ");
                        stud.setSid(scanner.nextInt());
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter First Name: ");
                        stud.setFname(scanner.nextLine());

                        System.out.print("Enter Last Name: ");
                        stud.setLname(scanner.nextLine());

                        System.out.print("Enter Contact Number: ");
                        stud.setContact(scanner.nextLong());
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter Email: ");
                        stud.setEmail(scanner.nextLine());

                        System.out.print("Enter City: ");
                        stud.setCity(scanner.nextLine());

                        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                        String date = scanner.nextLine();
                        stud.setDob(LocalDate.parse(date));

                        manager.persist(stud);
                    }
                    transaction.commit();
                    System.out.println("\n" + numStudents + " Students Added Successfully!");
                    break;

                case 2:
                    // Search for a student by ID
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = manager.find(Student.class, searchId);

                    if (foundStudent != null) {
                        System.out.println("\nStudent Details:");
                        System.out.println(foundStudent);
                    } else {
                        System.err.println("Student Not Found!");
                    }
                    break;

                case 3:
                    // Remove a student by ID
                    System.out.print("Enter Student ID to Remove: ");
                    int removeId = scanner.nextInt();

                    transaction.begin();
                    Student studentToRemove = manager.find(Student.class, removeId);
                    if (studentToRemove != null) {
                        manager.remove(studentToRemove);
                        transaction.commit();
                        System.out.println("Student Removed Successfully!");
                    } else {
                        System.err.println("Student Not Found!");
                        transaction.rollback();
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting... Goodbye!");
                    manager.close();
                    factory.close();
                    scanner.close();
                    return;

                default:
                    System.err.println("Invalid Option, please try again.");
            }
        }
    }
}
