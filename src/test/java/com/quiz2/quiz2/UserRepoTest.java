package com.quiz2.quiz2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import com.quiz2.quiz2.model.User;
import com.quiz2.quiz2.repo.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	//creating a new user
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFirstName("Ali");
		user.setLastName("Abdaal");
		user.setEmail("aliali23232@gmail.com");
		user.setPassword("12345678");
		
		// save it into the database
		User savedUser = repo.save(user);
		
		// assert user
		User existUser = entityManager.find(User.class, savedUser.getId());
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}

	@Test
	public void testFindUserByEmail(){
		String email = "rainata1234@gmail.com";
		User user = repo.findByEmail(email);
		assertThat(user).isNotNull();
	}
}
