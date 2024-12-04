package edu_jsp_ExpenceCreate;

import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManagement exm=new ExpenseManagement();

        while (true) {
            System.out.println("Expense Management System");
            System.out.println("1. Add Expense");
            System.out.println("2. Get Expense by ID");
            System.out.println("3. Remove Expense");
            System.out.println("4. Modify Expense");
            System.out.println("5. Get All Expence");
            System.out.println("6. Get Expense By Category");
            System.out.println("7. Expense Between  Given Amount");
            System.out.println("8. Remove Expense by Category");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                	Expense ex=new Expense();
                	 System.out.println("Enter expenseId: ");
                     int expenseId = scanner.nextInt();
                     ex.setExpenseId(expenseId);
                     System.out.println("Enter Category: ");
                     String category = scanner.next();
                     ex.setCategory(category);
                     System.out.println("Enter Description: ");
                     String description = scanner.next();
                     ex.setDescription(description);
                     System.out.println("Enter Amount: ");
                     double amount = scanner.nextDouble();
                     ex.setAmount(amount);
                    exm.addExpense(ex);
                    break;

                case 2:
                     System.out.println("Enter expenseId: ");
                      int Id = scanner.nextInt();
                      exm.getExpenseById(Id);
                      
                    break;

                case 3:
                    System.out.println("Enter expenseId: ");
                    int Id1 = scanner.nextInt();
                    exm.removeExpense(Id1);
                    break;

                case 4:
                	Expense ex1=new Expense();
               	 System.out.println("Enter expenseId: ");
                    int expenseId1 = scanner.nextInt();
                    
                    System.out.println("Enter Category: ");
                    String category1 = scanner.next();
                    ex1.setCategory(category1);
                    System.out.println("Enter Description: ");
                    String description1 = scanner.next();
                    ex1.setDescription(description1);
                    System.out.println("Enter Amount: ");
                    double amount1 = scanner.nextDouble();
                    ex1.setAmount(amount1);
                   exm.modifyExpense(ex1,expenseId1);
                    break;

                case 5:
                	
                	exm.getALLExpense();
                   
                    scanner.close();
                   
                    break;
                    
                case 6:  
                	System.out.println("Enetr the Category");
                	String cat=scanner.next();
                	exm.getExpenseByCategory(cat);
                
                	break;
                	
                case 7:  
                	System.out.println("Enetr the Min Amount");
                	double min=scanner.nextDouble();
                	System.out.println("Enter the Max Amount");
                	double max=scanner.nextDouble();
                	exm.expenseBetweenGivenAmountRange(min,max);
                
                	break;
                	
                case 8:  
                	System.out.println("Enetr category ");
                	String cate=scanner.next();
                	exm.removeExpenseByCategory(cate);
                
                	break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

   
//getALLExpence no argu
//getExpenceByCategory
//ExpenceBetGivenAmountRange
//removeExpenceByCategory  
   
}
