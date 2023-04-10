package com.cloudone.astores;

import com.cloudone.astores.entitiy.Product;
import com.cloudone.astores.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {
	@Autowired private ProductRepository repo;
	
	@Test
	public void testCreateProducts() {
		Product laptopH = new Product("Air Filter","Filter","Performance",10.99);
		Product laptopD = new Product("Engine Oil","Performence","Oil",82.55);
		Product laptopA = new Product("Brakes Pad","Braking","Utility",50.88);
		Product laptopC = new Product("Oil Filter","Filter","Oil",12.99);
		repo.saveAll(List.of(laptopH, laptopD, laptopA, laptopC));
		
		long count = repo.count();
		assertEquals(4, count);
	}
}
