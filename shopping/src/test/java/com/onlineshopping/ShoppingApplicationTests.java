package com.onlineshopping;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineshopping.dao.ProductDAO;
import com.onlineshopping.dao.UserDAO;
import com.onlineshopping.entity.Product;
import com.onlineshopping.entity.User;

@SpringBootTest
class ShoppingApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Autowired
	ProductDAO pRepo;
	
	@Autowired
	UserDAO uRepo;

	@Test
	 void testCreate(){
		Product p = new Product();
		p.setProdId(1);
		p.setProdName("Sony earphones");
		p.setProdPrice(200.00);
		p.setProdQuantity(4);
		pRepo.save(p);
		assertNotNull(pRepo.findById(1).get());
		
		
		User u = new User();
		u.setUserEmail("xyz@yahoo.com");
		u.setUserId("900");
		u.setUserName("Dummyy");
		u.setPassword("passwordd");
		u.setuFirstName("Dummyy");
		u.setuLastName("Testt");
		u.setUserAddress("Dummy areaa");
		u.setPhone(8488833L);

		uRepo.save(u);
		assertNotNull(uRepo.findById("900").get());
	}
	
}
