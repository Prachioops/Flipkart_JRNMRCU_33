package flipkart.service;
import java.util.*;
import flipkart.model.*;

public interface AdminOnProduct {

	boolean add(Product product);

	boolean update(int productId);

	boolean delete(int productId);

	Product getProduct(int productId);

	List<Product> getAllProduct();
}
