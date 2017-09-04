package org.itstep.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;

import org.itstep.App;
import org.itstep.dao.pojo.User;
import org.itstep.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	
	@MockBean
	UserService userService;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("ignatenko2207@gmail.com");
		user.setPassword("248842");
		user.setFirstName("Alex");
		user.setLastAction(System.currentTimeMillis());
		when(userService.getUser(user.getEmail(), user.getPassword())).thenReturn(null);
		when(userService.createAndUpdateUser(user)).thenReturn(user);
		RequestEntity<User> reqEntity = null;
		try {
			reqEntity = new RequestEntity<User>(user, HttpMethod.POST, new URI("/user"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<User> respEntity = testRestTemplate.exchange(reqEntity, User.class);
		assertEquals(HttpStatus.CREATED, respEntity.getStatusCode());
		verify(userService, times(1)).createAndUpdateUser(user);
	}

	@Test
	public void testUpdateUser() {
	}

	@Test
	public void testGetUser() {
	}

	@Test
	public void testDeleteUser() {
		User user = new User();
		user.setUserId(123456L);
		user.setEmail("ignatenko2207@gmail.com");
		user.setPassword("248842");
		user.setFirstName("Alex");
		user.setLastAction(System.currentTimeMillis()); 
		when(userService.getUser(user.getEmail(), user.getPassword())).thenReturn(user);
		doNothing().when(userService).deleteUser(user.getUserId());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity responseEntity = testRestTemplate.exchange("/user/?email="+user.getEmail()+"&password="+user.getPassword(), 
				HttpMethod.DELETE, entity, ResponseEntity.class, user.getEmail(), user.getPassword());	
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		verify(userService, times(1)).deleteUser(user.getUserId());
	}

}
