package flipkart.dao;
import java.text.SimpleDateFormat;
import java.util.*;


import flipkart.model.*;
import flipkart.util.*;


public class IProductDao implements ProductDao {

	private static Map<Long, Product> products;
	private static long origin = 1200L;

	static {

		products = new HashMap<Long, Product>();

	}

	@Override
	public boolean add(Product product) {

		/*Putting the products size in initial size.Then adding products which we got from presentation layer 
		into the hashmap. Size of hashmap is increased after adding. Then compare current size with initial size. If
		it is greater then product is added return true*/
		
		int initialSize = products.size();

		products.put(origin++, product);

		if (products.size() > initialSize)
			return true;
		else
			return false;

	}

	@Override
	public boolean update(int productId) {
		/* get id from the hashmap and compare it with the productId we got from presentation layer ,if it matches 
		 then ask for product details and replace it with the old one */
		for(Map.Entry<Long, Product> entry: products.entrySet())
		{
			Product obj=new Product();
			obj=entry.getValue();
			if(obj.getId()==productId)
			{
				Scanner scanner = InputUtil.getScanner();
				System.out.println("Enter Product id, name, price, quantity, Manufacturing Date (dd-MM-yyyy), Expiry Date (dd-MM-yyyy): ");
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
					Product prod = new Product(id, name, price, quantity,mfd,expiry);
					products.replace(entry.getKey(), prod);
				} catch (Exception dateException) {
					System.out.println(dateException);
				}
				Product prod = new Product(id, name, price, quantity);
				products.replace(entry.getKey(), prod);
				return true;
			
			}
		}

		return false;
	}

	@Override
	public boolean delete(int productId) {
		
		/* Compare productId recieved from presentation layer with ids in hashmap. If it matches then remove that 
		 key from hashmap and return true*/
		
		for(Map.Entry<Long, Product> entry:products.entrySet())
		{
			Product obj=new Product();
			obj=entry.getValue();
			if(obj.getId()==productId)
			{
				products.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}

	@Override
	public Product getProduct(int productId) {
		/* Compare the productId with hashmap keys and if it matches then get value of that key and return it.  */
		
		for(Map.Entry<Long, Product> entry:products.entrySet())
		{
			Product obj=new Product();
			obj=entry.getValue();
			if(obj.getId()==productId)
			{
				return obj;
			}
		}
		return new Product();
	}

	@Override
	public List<Product> getAllProduct() {
		//Shows the list of all the products//
		ArrayList<Product> list=new ArrayList<Product>();
		Collection<Product> productlist=products.values();
		for(Product p:productlist)
		{
			list.add(p);
			
		}	
		return list;
		}
}


