package edu.jsp.primary_key;


import java.util.List;

import edu.jsp.primary_key.Institute;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class InstituteManagement {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("hib");
	EntityManager manager=factory.createEntityManager();
	
	
public void addInstitute(Institute ins) {
    	
    	
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		 manager.persist(ins);
		 
		transaction.commit();
        
    }

public Institute getInstituteById(int id) {
	
	Institute inst=manager.find(Institute.class, id);
	System.out.println(inst);
	return inst;
}

public boolean removeInstitute(int id) {

	EntityTransaction transaction = manager.getTransaction();
	transaction.begin();
	// first find record - which needs to delete
	Institute institute=manager.find(Institute.class, id);
	  //delete
	  if(institute!=null) {
		  manager.remove(institute);
		  System.out.println("Record Deleted...");
		  return true;
	  }else {
		  System.err.println("No Data Found");
	  }
	transaction.commit();
	 return false;
	
	
	
    
}

public Institute modifyInstitute(Institute inst, int id) {
	
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	
	Institute ins=manager.find(Institute.class, id);
	System.out.println("Before: "+inst);
	if(inst!=null) {
		ins.setId(id);
		ins.setName(inst.getName());
		ins.setArea(inst.getArea());
		ins.setPincode(inst.getPincode());
		ins.setTechnology(inst.getTechnology());
		Institute modifiedInst=manager.merge(inst);
		System.out.println("after: "+modifiedInst);
		
		return inst;
	}else {
		System.out.println("no data found");
	}
	transaction.commit();
	return null;
}

public void getALLInstitute() {
	
	
	String query="Select inst from Institute inst";
	Query jpql=manager.createQuery(query);
	
	List<Institute> lt=jpql.getResultList();
	
	if(lt.isEmpty()) {
		System.err.println("No Records Find");
	}else {
		for(Institute inst: lt) {
			System.out.println(inst);
		}
	}
	
}

public void getInstituteByArea(String area ) {
	
	String query="select inst from Institute inst where area=?1 order by area";
	
	Query jpql=manager.createQuery(query);
	
	jpql.setParameter(1, area);
	
	
	List<Institute> lt=jpql.getResultList();
	
	
	if(lt.isEmpty()) {
		System.err.println("No Records Find");
	}else {
		for(Institute inst: lt) {
			System.out.println(inst);
		}
	}
	
	
	

}
public void expenseBetweenGivenFeeRange(double min, double max) {
	
	String query="select exp from Institute exp where amount between ?1 and ?2";
	 Query jpql=manager.createQuery(query);
	 jpql.setParameter(1, min);
	 jpql.setParameter(2, max);
	 
	 List<Institute> lt=jpql.getResultList();
	 
	 if(lt.isEmpty()) {
			System.err.println("No Records Find");
		}else {
			for(Institute e1: lt) {
				System.out.println(e1);
			}
		}
	 
}
public boolean removeInstituteByArea(String area) {

	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	String query="delete from Institute  where area=?1 ";

	 Query jpql=manager.createQuery(query);
	 jpql.setParameter(1, area);
	int records= jpql.executeUpdate();
	if(records != 0) {
		System.err.println("Records is deleted");
		return true;
	}else {
		System.err.println("Record Is Not Found");
		
	}
	
	transaction.commit();
	return false;
}

}
