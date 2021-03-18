package flipkart.controller;

import flipkart.service.*;
import java.util.*;
import flipkart.model.*;
import flipkart.util.*;



public class CustomerController {
	private static ICustomerOperations customerWork = new CustomerOperations();

	public void operations() {
		Scanner scanner = InputUtil.getScanner();
		boolean flag = true;
		int id;
		
		// Welcome to customer login page//

		while (flag) {
			System.out.println("*Welcome to Customer*");
			System.out.println(
					" 1. Register \n 2. View Non-Expired Products \n 3. Add product to cart \n 4. View cart \n 5. Exit");

			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			
			// Based on choice you can perform 5 operations//

			switch (choice) {

			case 1:
				Customer customer = readCustomerInfo();
				// Take customer info and pass to dao layer if it returns true then print what is written below//
				
				if (customerWork.register(customer)) {
					System.out.println("Customer with customer ID: " + customer.getId() + " added successfully!");
				} else {
					System.out.println("Customer not added.!");
				}
				break;

			case 2:
				System.out.println("The following are the non expired products");
				List<Product> list = customerWork.view();
				Product obj2 = new Product();
				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						obj2 = list.get(i);
						System.out.println(obj2);
					}
				} else
					System.out.println("No non expired product available");
				break;

			case 3:
				System.out.println("Enter Product Id to be entered in the cart: ");
				id = scanner.nextInt();
				
				// Take product id and pass to dao layer if it returns true then print what is written below//
				
				System.out.println("Enter Customer Id: ");
				int custId = scanner.nextInt();

				if (customerWork.add(id, custId) == true)
					System.out.println("Product is sucessfully Added: ");
				else
					System.out.println("Product does not exist");
				break;

			case 4:
				
				/*take customer id and pass to dao layer if it is null then print "cart is empty" .If cart
				has something then view it to the customer. */
				
				System.out.println("Enter Customer Id");
				id = scanner.nextInt();
				if (customerWork.viewCart(id).size() == 0) {
					System.out.println("Cart is empty: ");
				} else {
					List<Product> cartList = new ArrayList<Product>();
					cartList = customerWork.viewCart(id);
					for (int i = 0; i < cartList.size(); i++)
						System.out.println(" " + cartList.get(i));
				}
				break;
			case 5:
				flag = false;
				System.out.println("Customer exit");
				break;
			default:
				System.out.println("Enter a valid choice");

			}

		}

	}

	private Customer readCustomerInfo() {

		//Take input from customer//
		
		Scanner scanner = InputUtil.getScanner();
		System.out.println("Enter id, name, phone,email, address");
		int id = scanner.nextInt();
		String name = scanner.next();
		Long phone = scanner.nextLong();
		String email = scanner.next();
		String address = scanner.next();

		Customer customer = new Customer(id, name, phone,email, address);
		return customer;
	}

}
