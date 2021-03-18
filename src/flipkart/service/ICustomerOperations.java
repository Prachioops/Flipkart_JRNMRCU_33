package flipkart.service;

import java.util.List;

import flipkart.model.Customer;
import flipkart.model.Product;

public interface ICustomerOperations {

	boolean register(Customer customer);

	List<Product> view();

	boolean add(int productId, int customerId);

	List<Product> viewCart(int cartId);

}
