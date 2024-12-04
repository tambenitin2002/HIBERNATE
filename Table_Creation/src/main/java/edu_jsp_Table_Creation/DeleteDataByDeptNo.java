package edu_jsp_Table_Creation;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DeleteDataByDeptNo {

	public static void main(String[] args) {
	  EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
	  EntityManager manager=factory.createEntityManager();
	  EntityTransaction transaction=manager.getTransaction();
	  transaction.begin();
	  String query ="DELETE FROM Employee WHERE deptNo=:number";
	  Query jpql=manager.createQuery(query);
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter Dept No");
	  jpql.setParameter("number", sc.nextInt());
	  int record=jpql.executeUpdate();
	  if(record!=0) {
		  System.out.println("No. of Records Deleted= "+ record);
	  }else {
		  System.err.println("No Data Found");
	  }
	  transaction.commit();
	}

}
