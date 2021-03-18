package flipkart.controller;
import java.util.*;

import flipkart.service.*;
import flipkart.util.*;
import flipkart.model.*;
import java.text.*;

public class AdminController {

	private static AdminOnProduct productWork = new IAdminOnProduct();

	public void operations() {
		Scanner scanner = InputUtil.getScanner();
		boolean flag = true;
		int id;
		
		
		System.out.println("Enter admin username:");
		String userName =scanner.next();
		System.out.println("Enter admin password:");
		String password=scanner.next();
		
		// Checking if entered username and password is correct or not//
		
		if (Admin.getUserName().equals(userName) && Admin.getPassword().equals(password)) {
			System.out.println("Welcome Admin");
		
			//If it matches then welcome to Admin//
		
		while (flag) {
			System.out.println("Welcome to Admin");
			System.out.println(
					" 1. Enter product \n 2. Update product \n 3. Remove product \n 4. View Product \n 5. View all Products \n 6. Exit");

			System.out.println("Enter your choice :");
			int choice = scanner.nextInt();
            
			//Based on user's choice choose different operations//
			
			switch (choice) {

			case 1:
				Product product = takeProductInfo();
				//product info is passed to dao layer. If it returns true then print what is written below//
				
				if (productWork.add(product)) {
					System.out.println("Product with id " + product.getId() + " is added successfully.!");
				} else {
					System.out.println("Product not added.!");
				}
				break;

			case 2:
				System.out.println("Enter Product id: ");
				id = scanner.nextInt();
				
				//product id is passed to dao layer. If it returns true then print what is written below//
				
				if (productWork.update(id) == true)
					System.out.println("Product is sucessfully updated ");
				else
					System.out.println("Product does not exist");
				break;

			case 3:
				System.out.println("Enter product id: ");
				id = scanner.nextInt();
				
				//product id is passed to dao layer. If it returns true then print what is written below//
				
				if (productWork.delete(id) == true)
					System.out.println("Product is sucessfully deleted");
				else
					System.out.println("Product does not exist");
				break;

			case 4:
				System.out.println("Enter Product id: ");
				id = scanner.nextInt();
				
				//product id is passed to dao layer. If it returns true then print what is written below//
				
				if (productWork.getProduct(id) == null) {
					System.out.println("Product does not exist ");
				} else {
					Product obj1 = new Product();
					obj1 = productWork.getProduct(id);
					System.out.println(" " + obj1.toString());
				}
				break;
			case 5:
				// Print the list to view all products //
				
				List<Product> list = productWork.getAllProduct();
				Product obj2=new Product();
				if (productWork.getAllProduct() != null) {
					for (int i = 0; i < list.size(); i++) {
						obj2=list.get(i);
						System.out.println(obj2.toString());
					}
				} else
					System.out.println("Add products in the list");
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Enter a valid choice");


			}

		}
		} else {
			System.out.println("Wrong credentials");
		}
	}
	
		
	

	private Product takeProductInfo() {
		
		//Take all the input from the user//

		Scanner scanner = InputUtil.getScanner();
		System.out.println(
				"Enter Product id, name, price, qty, Manufacturing Date (dd-MM-yyyy), Expiry Date (dd-MM-yyyy): ");
		int id = scanner.nextInt();
		String name = scanner.next();
		int price = scanner.nextInt();
		int quantity = scanner.nextInt();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date1 = scanner.next();
		String date2 = scanner.next();
		try {
			Date mfd = dateFormat.parse(date1);
			Date expiry = dateFormat.parse(date2);
			return new Product(id, name, price, quantity, mfd, expiry);
		} catch (Exception dateException) {
			System.out.println(dateException);
		}

		return new Product(id, name, price, quantity);
	}
	}



