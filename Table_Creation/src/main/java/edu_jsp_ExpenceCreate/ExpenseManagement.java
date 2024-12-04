package edu_jsp_ExpenceCreate;



import java.time.LocalDate;
import java.util.List;

import edu_jsp_Table_Creation.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ExpenseManagement {
	

    public void addExpense(Expense exp) {
    	
    	EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		 manager.persist(exp);
		 
		transaction.commit();
        
    }

    public Expense getExpenseById(int id) {
    	EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		Expense exp=manager.find(Expense.class, id);
		System.out.println(exp);
		return exp;
    }

    public void removeExpense(int id) {
    	EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		// first find record - which needs to delete
		Expense exp=manager.find(Expense.class, id);
		  //delete
		  if(exp!=null) {
			  manager.remove(exp);
			  System.out.println("Record Deleted...");
		  }else {
			  System.err.println("No Data Found");
		  }
		transaction.commit();
        
    }

    public void modifyExpense(Expense ex1, int id) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		Expense exp=manager.find(Expense.class, id);
		System.out.println("Before: "+exp);
		if(exp!=null) {
			exp.setExpenseId(id);
			exp.setCategory(ex1.getCategory());
			exp.setDescription(ex1.getDescription());
			exp.setAmount(ex1.getAmount());
			Expense modifiedExp=manager.merge(exp);
			System.out.println("after: "+modifiedExp);
		}else {
			System.out.println("no data found");
		}
		transaction.commit();
    	
    }
    
    public void getALLExpense() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager= factory.createEntityManager();
		
		String query="Select exp from Expense exp";
		Query jpql=manager.createQuery(query);
		
		List<Expense> lt=jpql.getResultList();
		
		if(lt.isEmpty()) {
			System.err.println("No Records Find");
		}else {
			for(Expense e1: lt) {
				System.out.println(e1);
			}
		}
    }
    
    public void getExpenseByCategory(String category ) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager= factory.createEntityManager();
		String query="select exp from Expense exp where category=?1 order by category";
		
		Query jpql=manager.createQuery(query);
		
    	jpql.setParameter(1, category);
    	
    	
    	List<Expense> lt=jpql.getResultList();
    	
    	
    	if(lt.isEmpty()) {
			System.err.println("No Records Find");
		}else {
			for(Expense e1: lt) {
				System.out.println(e1);
			}
		}
    }
    public void expenseBetweenGivenAmountRange(double min, double max) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager= factory.createEntityManager();
		String query="select exp from Expense exp where amount between ?1 and ?2";
		 Query jpql=manager.createQuery(query);
		 jpql.setParameter(1, min);
		 jpql.setParameter(2, max);
		 
		 List<Expense> lt=jpql.getResultList();
		 
		 if(lt.isEmpty()) {
				System.err.println("No Records Find");
			}else {
				for(Expense e1: lt) {
					System.out.println(e1);
				}
			}
    }
    public void removeExpenseByCategory(String category) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		String query="delete from Expense  where category=?1 ";

		 Query jpql=manager.createQuery(query);
		 jpql.setParameter(1, category);
		int records= jpql.executeUpdate();
		if(records != 0) {
			System.err.println("Records is deleted");
		}else {
			System.err.println("Record Is Not Found");
		}
		
		transaction.commit();
    }
}
