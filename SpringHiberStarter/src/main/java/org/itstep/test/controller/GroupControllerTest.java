package org.itstep.test.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.itstep.test.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@MockBean
	GroupService groupService;
	
	@Test
	public void testSaveGroup() {
		Group group = new Group();
		group.setGroupName("J3");
		group.setCourse(23);
		Mockito.when(groupService.createAndUpdateGroup(group)).thenReturn(group);
		Mockito.when(groupService.isUnique(group)).thenReturn(true);
		
		 RequestEntity<Group> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Group>(group, HttpMethod.POST, new URI("/group"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testUpdateGroup() {
	}

	@Test
	public void testGetGroup() {
	}

	@Test
	public void testGetGroupsByCourse() {
	}

	@Test
	public void testDeleteGroup() {
	}

}
