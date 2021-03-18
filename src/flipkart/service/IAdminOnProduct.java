package flipkart.service;
import java.util.*;
import flipkart.dao.*;
import flipkart.model.*;


public class IAdminOnProduct implements AdminOnProduct {

	private static ProductDao ProductDao = new IProductDao();

	@Override
	public boolean add(Product product) {
		return ProductDao.add(product);
	}

	@Override
	public boolean update(int id) {

		return ProductDao.update(id);
	}

	@Override
	public boolean delete(int productId) {
		return ProductDao.delete(productId);
	}

	@Override
	public Product getProduct(int productId) {
		return ProductDao.getProduct(productId);
	}

	

	@Override
	public List<Product> getAllProduct() {
		return ProductDao.getAllProduct();
	}

}
