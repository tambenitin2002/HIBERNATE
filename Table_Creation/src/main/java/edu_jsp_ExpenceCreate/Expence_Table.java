package edu_jsp_ExpenceCreate;
import jakarta.persistence.*;

public class Expence_Table {

	
	
		public static void main(String[] args) {
			EntityManagerFactory factory= Persistence.createEntityManagerFactory("hibernate");
			
			EntityManager manager=factory.createEntityManager();

		}

	}


