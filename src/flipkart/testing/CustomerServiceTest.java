package flipkart.testing;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import flipkart.dao.*;
import flipkart.model.Product;
import flipkart.service.AdminOnProduct;
import flipkart.service.*;

class CustomerServiceTest {

	private CustomerOperations obj;
	private List<Product> list;
	private Product e = new Product();
	private ProductDao prod;
	private AdminOnProduct admin;

	@BeforeEach
	void setUp() throws Exception {
		obj = new CustomerOperations();
		list = new ArrayList<Product>();
		e = new Product();
		prod=new IProductDao();
		admin=new IAdminOnProduct();

	}

	@AfterEach
	void tearDown() throws Exception {
		obj = null;
		list=null;

	}

	@Test
	void addTest() {
		assertEquals(obj.add(1001, 1001), true);
	}

	@Test
	void viewCartTest() {
		e.setId(2002);
		list.add(e);
		admin.add(e);
		obj.add(2002, 2002);
//		System.out.println("List- "+list);
//		System.out.println(obj.viewCart(1234)+"\n"+obj.viewCart(2002));
		assertNotEquals(obj.viewCart(1234), list);
		assertEquals(obj.viewCart(2002), list);

	}

	@Test
	void viewTest() {

		assertNotEquals(obj.view(), list);

		String s = "22-02-2021";
		Date date1;
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(s);
			e.setExpiryDate(date1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		list.add(e);
		System.out.println(obj.view()+"\n"+"List- "+list);

		assertNotEquals(obj.view(), list);

	}

	@Test
	void viewTest1() {
		String s = "22-02-2022";
		try {
			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(s);
			e.setId(1001);
			e.setExpiryDate(date1);
			prod.add(e);			
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		list.add(e);
		List<Product> l1=new ArrayList<Product>();
		l1=obj.view();
		
		assertEquals(obj.view(), l1);

	}
	

}