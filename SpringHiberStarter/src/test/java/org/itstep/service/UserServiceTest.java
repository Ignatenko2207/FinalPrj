package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.App;
import org.itstep.dao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testGetUser() {
		User user = new User();
		user.setEmail("ignatenko2207@gmail.com");
		user.setPassword("248842");
		user.setFirstName("Alex");
		user.setLastAction(System.currentTimeMillis());
		userService.createAndUpdateUser(user);
		User userDB = userService.getUser(user.getEmail(), user.getPassword());
		assertNotNull(userDB);
		userService.deleteUser(userDB.getUserId());
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("ignatenko2207@gmail.com");
		user.setPassword("248842");
		user.setFirstName("Alex");
		user.setLastAction(System.currentTimeMillis());
		userService.createAndUpdateUser(user);
		User userDB = userService.getUser(user.getEmail(), user.getPassword());
		assertNotNull(userDB);
		userService.deleteUser(userDB.getUserId());
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setEmail("ignatenko2207@gmail.com");
		user.setPassword("248842");
		user.setFirstName("Alex");
		user.setLastAction(System.currentTimeMillis());
		userService.createAndUpdateUser(user);
		User userDB = userService.getUser(user.getEmail(), user.getPassword());
		User updUser = new User();
		updUser.setUserId(userDB.getUserId());
		updUser.setEmail("ignatenko2207@gmail.com");
		updUser.setPassword("555555555");
		updUser.setFirstName("Alex");
		updUser.setLastAction(System.currentTimeMillis());
		updUser.setSecondName("Ignatenko");;
		userService.createAndUpdateUser(updUser);
		User updUserDB = userService.getUser(updUser.getEmail(), updUser.getPassword());
		assertNull(userService.getUser(user.getEmail(), user.getPassword()));
		assertNotNull(updUserDB);
		userService.deleteUser(updUserDB.getUserId());
	}

}
