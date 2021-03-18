package flipkart.dao;

import java.util.List;

import flipkart.model.Product;

public interface ICartDao {
	

	public boolean add(Product prod, int customerId);

	public List<Product> viewCart(int id);

}
