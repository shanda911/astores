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
		Product laptopH = new Product("HP-10","Laptop","Sample",10.22);
		Product laptopD = new Product("DELL-18","Laptop","Sample",82.55);
		repo.saveAll(List.of(laptopH, laptopD));
		
		long count = repo.count();
		assertEquals(2, count);
	}
}
