package edu.jsp.primary_key;

import java.util.Scanner;
import edu.jsp.primary_key.Institute;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InstituteApp {

	public static void main(String[] args) {
		InstituteManagement inst=new InstituteManagement();
		 Scanner sc=new Scanner(System.in);
		 
		 boolean flag=true;
		  
		 while(flag) {
		System.out.println("Expense Management System \n 1. Add Institute \n 2. Get Institute by ID \n 3. Remove Institute \n 4. Modify Institute \n 5. Get All Institute \n 6. Get Institute By area \n 7. Institute Between  Given Amount \n 8. Remove Institute by area \n 9. Exit \n Enter your Choice ");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
		{
			Institute ins=new Institute();
//			 System.out.println("Enter Institute Id: ");
//            int id = sc.nextInt();
//            ins.setId(id);
            System.out.println("Enter Institute name: ");
            String name = sc.next();
            ins.setName(name);
            System.out.println("Enter Institute area: ");
            String area = sc.next();
            ins.setArea(area);
            System.out.println("Enter Institute Pincode: ");
            int pincode=sc.nextInt();
            ins.setPincode(pincode);
            System.out.println("Enter Institute technology: ");
            String tech = sc.next();
            ins.setTechnology(tech);
            System.out.println("Enter Institute Fees: ");
            double fee = sc.nextDouble();
            ins.setFee(fee);
            
           inst.addInstitute(ins);
			
			break;
		}
		
		case 2:
		{
			System.out.println("Enter expenseId: ");
            int id = sc.nextInt();
            inst.getInstituteById(id);
            
          break;
		}
		case 3:
		{
			System.out.println("Enter expenseId: ");
            int id = sc.nextInt();
            inst.removeInstitute(id);
            break;
		}
		case 4:
		{
			
			Institute ins=new Institute();
			 System.out.println("Enter Institute Id: ");
           int id = sc.nextInt();
           ins.setId(id);
           System.out.println("Enter Institute name: ");
           String name = sc.next();
           ins.setName(name);
           System.out.println("Enter Institute area: ");
           String area = sc.next();
           ins.setArea(area);
           System.out.println("Enter Institute Pincode: ");
           int pincode=sc.nextInt();
           ins.setPincode(pincode);
           System.out.println("Enter Institute technology: ");
           String tech = sc.next();
           ins.setTechnology(tech);
              inst.modifyInstitute(ins,id);
               break;
		}
		case 5:
		{
			inst.getALLInstitute();
			break;
		}
		case 6:
		{
			System.out.println("Enetr the area");
        	String area=sc.next();
        	inst.getInstituteByArea(area);
        
        	break;
		}
		case 7: 
		{
			System.out.println("Enetr the Min Fee");
        	double min=sc.nextDouble();
        	System.out.println("Enter the Max Fee");
        	double max=sc.nextDouble();
        	inst.expenseBetweenGivenFeeRange(min,max);
        
        	break;
		}
		case 8:
		{
			System.out.println("Enetr category ");
        	String area=sc.next();
        	inst.removeInstituteByArea(area);
        
        	break;
		}
		case 9:
		{
			flag=false;
		}
			

		default:
			break;
		}
		

		 }
	}

	

}
