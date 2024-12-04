package org.jsp.EmployeeTable;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class Application {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("uni-directional");
	   EntityManager manager=factory.createEntityManager();
	   Scanner sc=new Scanner(System.in);
	   Employee employee=new Employee();
	   SalaryAccount salaryaccount=new SalaryAccount();
	 public void addEmployee() {
		   EntityTransaction transaction=manager.getTransaction();
		   transaction.begin();
		     System.out.println("Enter the Employee Name: ");
		     String name=sc.next();
		     employee.setEname(name);
		     System.out.println("Enter the Employee Email: ");
		     String email=sc.next();
		     employee.setEmail(email);
		     System.out.println("Enter the mobile number: ");
		     long mobile=sc.nextLong();
		     employee.setMobile(mobile);
		     
		     manager.persist(employee);
		   transaction.commit();
	   }
	 public void addSalary() {
		 EntityTransaction transaction=manager.getTransaction();
		   transaction.begin();
		   System.out.println("Enter the bank name: ");
		   String bankName=sc.next();
		   salaryaccount.setBankName(bankName);
		   System.out.println("Enter the Balance: ");
		   double balance=sc.nextDouble();
		   salaryaccount.setBalance(balance);
		   System.out.println("Enter Employee Id: ");
		   Employee employee=manager.find(Employee.class, sc.nextInt());
		   if(employee!=null) {
			  employee.setSalaryaccount(salaryaccount);
			  manager.persist(salaryaccount);
			  manager.merge(employee);
		   }
		     
		   transaction.commit();
	 }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	   Application application=new Application();
	   boolean flag=true;
	   while(true) {
		   System.out.println("Perform following operations \n 1. Add Employe \n 2.add salaryaccount \n 9. Exit \n Enter Your Choice: ");
		   int choice=sc.nextInt();
		   switch (choice) {
		case 1:
			application.addEmployee();
			break;
		case 2:
			application.addSalary();
			break;
		case 9:
			flag=false;
		default:
			break;
		}
	   }
	   
	  
	   

	}

}