package flipkart.service;

import java.util.List;
import java.util.Date;

import flipkart.dao.*;
import flipkart.model.*;

public class CustomerOperations implements ICustomerOperations {

	CustomerDao customerDao = new CustomerDao();
	CartDao cartDao = new CartDao();
	IProductDao productDao = new IProductDao();

	@Override
	public boolean register(Customer customer) {
		return customerDao.register(customer);
	}
	@Override
	public List<Product> view() {
		/*get all products in nonExpiredProducts list and then take system date and compare products. 
		 Remove those products whose expiry date is not reached and return remaining list*/
		List<Product> nonExpiredProducts;
		nonExpiredProducts = productDao.getAllProduct();
		Product p=new Product();
		Date date=new Date();
		for(int i=0; i<nonExpiredProducts.size(); i++)
		{
			p=nonExpiredProducts.get(i);
			if(date.before(p.getExpiryDate()))
			{
				nonExpiredProducts.remove(i);
			}}
		return nonExpiredProducts;

	}

	@Override
	public boolean add(int productId, int customerId) {

		Product prod = productDao.getProduct(productId);
		return cartDao.add(prod, customerId);
	}

	@Override
	public List<Product> viewCart(int cartId) {

		return cartDao.viewCart(cartId);
	}

}
