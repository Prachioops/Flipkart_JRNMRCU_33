package flipkart.dao;

import java.util.HashMap;

import flipkart.model.Customer;

public class CustomerDao implements ICustomerDao {
	ICartDao cartDao = new CartDao();
	private static HashMap<Integer, Customer> customerCart;
	private static int cartAddress = 1;

	static {
		customerCart = new HashMap<Integer, Customer>();
	}

	@Override
	// Register the user and return true//
	public boolean register(Customer customer) {
 
		int initialSize = customerCart.size();

		customerCart.put(cartAddress, customer);

		if (customerCart.size() > initialSize)
			return true;
		else
			return false;
	}

}
