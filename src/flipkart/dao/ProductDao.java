package flipkart.dao;
import java.util.*;
import flipkart.model.*;

public interface ProductDao {

	public boolean add(Product product);

	public boolean update(int productId);

	public boolean delete(int productId);

	public Product getProduct(int productId);

	public List<Product> getAllProduct();
}
