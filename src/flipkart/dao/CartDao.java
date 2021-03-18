package flipkart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import flipkart.model.*;

public class CartDao implements ICartDao {
	static HashMap<Integer, ArrayList<Product>> cart;
	static {
		cart = new HashMap<Integer, ArrayList<Product>>();
	}

	@Override
	public boolean add(Product prod, int customerId) {
		//check if there is cart on this customerId ,if yes add in that cart otherwise create one with that customerId//
		
		ArrayList<Product> arr1 = new ArrayList<Product>();
		if (cart.containsKey((Object) customerId)) {
			(cart.get(customerId)).add(prod);
			return true;
		} else {
			arr1.add(prod);
			cart.put(customerId, arr1);
			return true;
		}

	}

	@Override
	public List<Product> viewCart(int id) {

		for (Map.Entry<Integer, ArrayList<Product>> entry : cart.entrySet()) {
			if (cart.containsKey(id)) {
				return (entry.getValue());
			}

		}
		return new ArrayList<Product>();

	}
}
