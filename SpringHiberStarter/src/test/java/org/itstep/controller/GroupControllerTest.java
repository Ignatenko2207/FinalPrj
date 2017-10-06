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
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupControllerTest {
	
	@Autowired
	Gson gson;
	
	@MockBean
	GroupService groupService;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void createGroupTest(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		String groupJsonObject = gson.toJson(group);
		Mockito.when(groupService.createAndUpdateGroup(Mockito.<Group>any())).thenReturn(group);
		Mockito.when(groupService.isUnique(Mockito.<Group>any())).thenReturn(true);
		Mockito.when(groupService.getGroup(Mockito.<String>any())).thenReturn(null);
		
		RequestEntity<String> reqEntity = null;
		try {
			reqEntity = new RequestEntity<String>(groupJsonObject, HttpMethod.POST, new URI("/group"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> respEntity = testRestTemplate.exchange(reqEntity, String.class);
		assertEquals(HttpStatus.CREATED, respEntity.getStatusCode());
		
		Mockito.verify(groupService, Mockito.times(1)).createAndUpdateGroup(Mockito.<Group>any());		
	}
	
	@Test
	public void updateGroupTest(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		String groupJsonObject = gson.toJson(group);
		Mockito.when(groupService.createAndUpdateGroup(Mockito.<Group>any())).thenReturn(group);
		Mockito.when(groupService.isUnique(Mockito.<Group>any())).thenReturn(false);
		Mockito.when(groupService.getGroup(Mockito.<String>any())).thenReturn(group);
		
		RequestEntity<String> reqEntity = null;
		try {
			reqEntity = new RequestEntity<String>(groupJsonObject, HttpMethod.PUT, new URI("/group"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> respEntity = testRestTemplate.exchange(reqEntity, String.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(groupService, Mockito.times(1)).createAndUpdateGroup(Mockito.<Group>any());
	}
	
	@Test
	public void getGroupTest(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		Mockito.when(groupService.getGroup(Mockito.anyString())).thenReturn(group);
		String groupJsonObject = gson.toJson(group);
		
		RequestEntity<String> reqEntity = null;
		try {
			reqEntity = new RequestEntity<String>(groupJsonObject, HttpMethod.GET, new URI("/group/get-group?groupName="+group.getGroupName()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> respEntity = testRestTemplate.exchange(reqEntity, String.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(groupService, Mockito.times(1)).getGroup(Mockito.<String>any());
	}

	@Test
	public void deleteGroup(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		Mockito.doNothing().when(groupService).deleteGroup(Mockito.<String>any());
		String groupJsonObject = gson.toJson(group);
		
		RequestEntity<String> reqEntity = null;
		try {
			reqEntity = new RequestEntity<String>(groupJsonObject, HttpMethod.DELETE, new URI("/group?groupName="+group.getGroupName()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> respEntity = testRestTemplate.exchange(reqEntity, String.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(groupService, Mockito.times(1)).deleteGroup(Mockito.<String>any());
	}
	
	@Test
	public void getGroupListTest(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		List<Group> groupList = Arrays.asList();
		Mockito.when(groupService.findAllGroupsByCourse(Mockito.anyInt())).thenReturn(groupList);
		String groupListJsonObject = gson.toJson(groupList);
		
		RequestEntity<String> reqEntity = null;
		try {
			reqEntity = new RequestEntity<String>(groupListJsonObject, HttpMethod.GET, new URI("/group/get-group-list?course="+group.getCourse()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> respEntity = testRestTemplate.exchange(reqEntity, String.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(groupService, Mockito.times(1)).findAllGroupsByCourse(Mockito.anyInt());
	}
	
}
