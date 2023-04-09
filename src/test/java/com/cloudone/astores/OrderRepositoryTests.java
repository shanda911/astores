package com.cloudone.astores;

import com.cloudone.astores.entitiy.Order;
import com.cloudone.astores.entitiy.Product;
import com.cloudone.astores.entitiy.Role;
import com.cloudone.astores.entitiy.User;
import com.cloudone.astores.repository.OrderRepository;
import com.cloudone.astores.repository.ProductRepository;
import com.cloudone.astores.repository.RoleRepository;
import com.cloudone.astores.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class OrderRepositoryTests {
	@Autowired private ProductRepository repoProduct;
	@Autowired private UserRepository repoUser;

	@Autowired private OrderRepository repo;
	
	@Test
	public void testCreateOrder() {
//		Product product = new Product(1);
//		Set prods = new HashSet<Product>();
//		prods.add(product);
//
//		Order o = new Order(prods, new Date(System.currentTimeMillis()), 100.22,  new User(1));
//
//		repo.save(o);
//
		long count = repo.count();
		assertEquals(1, count);
	}
}
