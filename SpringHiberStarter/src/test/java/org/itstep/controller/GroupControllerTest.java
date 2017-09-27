package org.itstep.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@MockBean
	private GroupService groupService;
//	

//	
	@Test
	public void testSaveGroup() {
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		when(groupService.createAndUpdateGroup(group)).thenReturn(group);
		when(groupService.isUnique(Mockito.any())).thenReturn(true);
		RequestEntity<Group> reqEntity = null;
		try {
			reqEntity = new RequestEntity(group, HttpMethod.POST, new URI("/group"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Group> respEntyty = testRestTemplate.exchange(reqEntity, Group.class);
		assertEquals(HttpStatus.CREATED, respEntyty.getStatusCode());

		verify(groupService, Mockito.times(1)).createAndUpdateGroup(Mockito.any());

	}

	@Test
	public void testUpdateGroup() {


	}

	@Test
	public void testGetGroup() {
	}

	@Test
	public void testGetGroupsByCourse() {
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		List<Group> groups = Arrays.asList(group);
		when(groupService.findAllByCourse(Mockito.anyInt())).thenReturn(groups);
		RequestEntity requestEntity = null;

		try {
			requestEntity = new RequestEntity(HttpMethod.GET,new URI("/group/get-groupList?course="+group.getCourse()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Group>> response = testRestTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<Group>>() {
		}
		);
		assertEquals(HttpStatus.OK,response.getStatusCode());


	}

	@Test
	public void testDeleteGroup() {
		Group group = new Group();
		group.setGroupName("J17");
		group.setCourse(2);
		groupService.createAndUpdateGroup(group);

		System.out.println(groupService.getGroup("J17"));

		groupService.deleteGroup(group.getGroupName());

		System.out.println(groupService.getGroup("J17"));









	}

}

