package org.jsp.many_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni-directional");
    static EntityManager manager = factory.createEntityManager();
    static EntityTransaction transaction = manager.getTransaction();

    public static void addDepartment(Department dept) {
        transaction.begin();
        manager.persist(dept);
        transaction.commit();
    }

    public static boolean addEmployeeWithDepartment(Employees emp, int deptNo) {
        Department dept = manager.find(Department.class, deptNo);
        if (dept != null) {
            emp.setDept(dept);
            transaction.begin();
            manager.persist(emp);
            transaction.commit();
            return true;
        }
        return false;
    }

    public static Employees findEmployeeById(int empId) {
    	Employees employee=new Employees();
        employee=manager.find(Employees.class, empId);
        if (employee != null) {
            System.out.println("Employee found: " + employee);
        } else {
            System.out.println("Employee not found!");
        }
       
        return null;  
    }
    public static Department findDepartmentById(int deptNo) {
    	 Department dept = manager.find(Department.class,deptNo);
         if (dept != null) {
             System.out.println("Department found: " + dept);
         } else {
             System.out.println("Department not found!");
         }
        
       return null;
    }

    public static List<Employees> findEmployeeByDeptNo(int deptNo) {
    	Employees employees = manager.find(Employees.class,deptNo);
        List<Employees> emplist=new ArrayList<Employees>();

        if (employees != null)  {
            for (Employees emp : emplist) {
                System.out.println("Data is found"+emp);
            }
        } else {
            System.out.println("No employees found in Department ");
        }
      
                return null;  
    }

    public static List<Department> findDepartmentByLocation(String location) {
    	
    	Department department=new Department();
    	String query="select dt from Department dt where location=?1";
    	Query jpql=manager.createQuery(query);
    	jpql.setParameter(1, location);
    	List<Department> lt=jpql.getResultList();
    	if(lt.isEmpty()) {
    		System.err.println("Data Not Found..");
    	}
    	else {
    		for(Department dept: lt) {
    			System.out.println(dept);
    		}
    	}
    	
       
        return null;  
    }

    public static boolean removeEmployeeById(int empId) {
    	transaction.begin();
    	Employees employee=new Employees();
    	employee = manager.find(Employees.class,empId);
    	if(employee != null) {
    		manager.remove(employee);
    	}else {
    		System.out.println("No Data Found");
    	}
    	transaction.commit();
            return false;
            
            
            
        }
         
    public static Employees modifyEmployee(Employees emp , int empId) {
    	
    	
    	transaction.begin();
    	
    	  Employees employee=new Employees();
    	  
    	   manager.find(Employees.class, empId);
    	   if(employee != null) {
    	   employee.setEmpId(empId);
    	   employee.setEname(employee.getEname());
    	   employee.setDept(employee.getDept());
    	   employee.setSalary(employee.getSalary());
    	   manager.merge(employee);
    	   }else {
    		   System.out.println("Employee Not Found! ");
    	   }
    	   
    	transaction.commit();
        return null;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Add Department Press 1");
            System.out.println("Add Employee Press 2");
            System.out.println("Find Employee by ID Press 3");
            System.out.println("Find Department by ID Press 4");
            System.out.println("Find Employees by Department Number Press 5");
            System.out.println("Find Departments by Location Press 6");
            System.out.println("Remove Employee by ID Press 7");
            System.out.println("Modify Employee by ID Press 8");
            System.out.println("Exit Press 0");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    Department dept = new Department();
                    System.out.println("Enter Department Name: ");
                    dept.setDepartmentName(sc.next());
                    System.out.println("Enter Location: ");
                    dept.setLocation(sc.next());

                    addDepartment(dept);
                    System.out.println("Department Added Successfully!!!!");
                    break;
                }
                case 2: {
                    Employees emp = new Employees();
                    System.out.println("Enter Department Number: ");
                    int deptNo = sc.nextInt();

                    System.out.println("Enter Employee Name: ");
                    emp.setEname(sc.next());
                    System.out.println("Enter Salary: ");
                    emp.setSalary(sc.nextDouble());

                    boolean status = addEmployeeWithDepartment(emp, deptNo);
                    if (status) {
                        System.out.println("Employee Added Successfully");
                    } else {
                        System.out.println("Department not found!");
                    }
                    break;
                }
                case 3:{
                	Employees employees=new Employees();
                	System.out.println("Enter the employee id : ");
                	int empid=sc.nextInt();
                	findEmployeeById(empid);
                	break;
                }
                case 4:{
                	  Department dept = new Department();
                	System.out.println("Enter the employee id : ");
                	int deptid=sc.nextInt();
                	findDepartmentById(deptid);
                	break;
                }
                case 5:{
              	  Department dept = new Department();
              	 System.out.println("Enter the Department id : ");
              	  int deptid=sc.nextInt();
              	findEmployeeByDeptNo(deptid);
              	break;
              }
                case 6:{
                	Department dept = new Department();
                	System.out.println("Enter the location: ");
                	String location=sc.next();
                	
                	findDepartmentByLocation(location);
                	break;
                }
                case 7:{
                	Employees employee=new Employees();
                	System.out.println("Enter the employee id: ");
                	int empid=sc.nextInt();
                	
                	removeEmployeeById(empid);
                	
                	break;
                	
                }
                
                case 8:{
                	Employees employee=new Employees();
                	System.out.println("Enter employee id: ");
                	int empid=sc.nextInt();
                	System.out.println("Enter the Employee name: ");
                	String name=sc.next();
                	employee.setEname(name);
                	
                	System.out.println("Enter the Employee salary: ");
                	double salary=sc.nextDouble();
                	employee.setSalary(salary);
                	
                	
                	
                	modifyEmployee(employee,empid);
                	
                	break;
                }
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
       
    }
}
