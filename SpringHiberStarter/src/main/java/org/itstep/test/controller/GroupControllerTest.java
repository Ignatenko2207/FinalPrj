package org.itstep.test.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.itstep.App;

import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Headers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	
	@Test
	public void testSaveGroup() {
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		when(groupService.createAndUpdateGroup(group)).thenReturn(group);
		when(groupService.isUnique(Mockito.<Group>any())).thenReturn(true);
		RequestEntity<Group> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Group>(group, HttpMethod.POST, new URI("/group"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Group> respEntyty = testRestTemplate.exchange(reqEntity, Group.class);
		assertEquals(HttpStatus.CREATED, respEntyty.getStatusCode());
		
		verify(groupService, Mockito.times(1)).createAndUpdateGroup(Mockito.<Group>any());
		
	}

	@Test
	public void testUpdateGroup() {
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		when(groupService.isUnique(Mockito.<Group>any())).thenReturn(false);
		when(groupService.createAndUpdateGroup(Mockito.<Group>any())).thenReturn(group);
		RequestEntity<Group> requestEntity = null;
		try {
			requestEntity = new RequestEntity<Group>(group, HttpMethod.PUT, new URI("/group"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Group> responseEntyty = testRestTemplate.exchange(requestEntity, Group.class);
		assertEquals(HttpStatus.OK, responseEntyty.getStatusCode());
		
		verify(groupService, Mockito.times(1)).createAndUpdateGroup(Mockito.<Group>any());
	}

	@Test
	public void testGetGroup() {
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		when(groupService.getGroup(Mockito.anyString())).thenReturn(group);
		HttpHeaders headers = new HttpHeaders();
		RequestEntity<String> requestEntity = null;
		try {
			requestEntity = new RequestEntity<String>(headers, HttpMethod.GET, new URI("/group/get-group?groupName="+group.getGroupName()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Group> responseEntyty = testRestTemplate.exchange(requestEntity, Group.class);
		assertEquals(HttpStatus.OK, responseEntyty.getStatusCode());
		
		verify(groupService, Mockito.times(1)).getGroup(Mockito.anyString());
		
	}

	@Test
	public void testGetGroupsByCourse() {
//		Group group = new Group();
//		group.setGroupName("J16");
//		group.setCourse(2);
//		//Group groupFromDB = groupService.createAndUpdateGroup(group);
//		List<Group> groupsDB = groupService.findAllByCourse(group.getCourse());
//		when(groupService.findAllByCourse(Mockito.anyInt())).thenReturn(groupsDB);
//		RequestEntity<Group> requestEntity = null;
//		try {
//			requestEntity = new RequestEntity<Group>(group, HttpMethod.GET, new URI("/get-grouplist"));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//		ResponseEntity<Group> responseEntyty = testRestTemplate.exchange(requestEntity, Group.class);
//		assertEquals(HttpStatus.CREATED, responseEntyty.getStatusCode());
//		
//		verify(groupService, Mockito.times(1)).findAllByCourse(Mockito.anyInt());
	}

	@Test
	public void testDeleteGroup() {
//		Group group = new Group();
//		group.setGroupName("J16");
//		group.setCourse(2);
//		Mockito.doNothing().when(groupService).deleteGroup(Mockito.anyString());
//		RequestEntity requestEntity = null;
//		try {
//			requestEntity = new RequestEntity(group, HttpMethod.DELETE, new URI("/group"));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//		ResponseEntity responseEntyty = testRestTemplate.exchange(requestEntity, Group.class);
//		assertEquals(HttpStatus.OK, responseEntyty.getStatusCode());
//		
//		verify(groupService, Mockito.times(1)).deleteGroup(Mockito.anyString());

	}

}

