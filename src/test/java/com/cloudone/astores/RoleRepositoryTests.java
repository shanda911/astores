package com.cloudone.astores;

import com.cloudone.astores.entitiy.Role;
import com.cloudone.astores.repository.RoleRepository;
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
public class RoleRepositoryTests {
	@Autowired private RoleRepository repo;
	
	@Test
	public void testCreateRoles() {
		Role admin = new Role("ADMIN");
		Role customer = new Role("CUSTOMER");
		
		repo.saveAll(List.of(admin, customer));
		
		long count = repo.count();
		assertEquals(2, count);
	}
}
