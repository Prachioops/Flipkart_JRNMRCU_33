package flipkart.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import flipkart.model.*;
import flipkart.util.*;
import flipkart.service.*;
import flipkart.dao.*;

public class MainController {

	private static AdminOnProduct productWork = new IAdminOnProduct();
	private static CustomerDao customer=new CustomerDao();
	public static void main(String[] args) {
        
		addFewProducts() ;
		doSomething();

	}
	
	//putting some dummy data//
	private static void addFewProducts() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date date1=dateFormat.parse("09-09-2019");
			Date date2=dateFormat.parse("23-10-2021");
			Date date3=dateFormat.parse("20-3-2020");
			Date date4=dateFormat.parse("01-01-2018");
			Date date5=dateFormat.parse("06-10-2019");
			Date date6=dateFormat.parse("08-07-2020");
			Date date7=dateFormat.parse("08-08-2021");
			Date date8=dateFormat.parse("01-12-2022");
			Product product1 = new Product(1001, "Cookies", 1, 1000,date1,date2);
			productWork.add(product1);
			Product product2 = new Product(2002, "Shampoo", 50, 50,date3,date4);
			productWork.add(product2);
			Product product3 = new Product(3003, "Chocolate", 20, 200,date5,date6);
			productWork.add(product3);
			Product product4 = new Product(4004, "Noodles", 45, 250,date7,date8);
			productWork.add(product4);

		} catch (Exception dateException) {
			System.out.println(dateException);
		}
		Customer c1=new Customer(1,"Prachi Chaudhary",3453453457L,"prachichaudhary408@gmail.com"," Janakpuri");
		Customer c2=new Customer(2,"Yukti Arora",890344632L,"yuktiarora@gmail.com","faridabad");
		customer.register(c2);
		customer.register(c1);

	}

	private static void doSomething() {
       // Asking for user's choice //
		
		Scanner scanner = InputUtil.getScanner();
		System.out.println("*Welcome to Flipkart*");
		System.out.println("1.Customer \n2.Admin \n3.Exit");

		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();
      
		// Using switch statement based on choice//
		
		switch (choice) {

		case 1:
			// Calls CustomerController's method named operations which will open customer welcome page//
			CustomerController customerController = new CustomerController();
      		customerController.operations();
			break;

		case 2:
			// Calls AdminController's method named operations which will open admin's welcome page//
			AdminController adminController = new AdminController();
			adminController.operations();
			break;

		case 3:
			//Exit program//
			System.out.println("We are exiting");
			System.exit(1);

		}

	}
}
