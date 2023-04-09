package com.cloudone.astores;

import com.cloudone.astores.entitiy.Role;
import com.cloudone.astores.entitiy.User;
import com.cloudone.astores.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired private UserRepository repo;
	
	@Test
	public void testCreateUser() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("test");
		
		User user = new User("user@mwn.com", password);
		User admin = new User("admin@mwn.com", password);
		repo.saveAll(List.of(admin, user));
		long count = repo.count();
		assertEquals(2, count);
//		assertThat(savedUser).isNotNull();
//		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testAssignRoleToUser() {
		Integer userId = 2;//2 is user
		Integer roleId = 2;
		User user = repo.findById(userId).get();
		user.addRole(new Role(roleId));
		
		User updatedUser = repo.save(user);
		assertThat(updatedUser.getRoles()).hasSizeGreaterThan(0);
		
	}
}
