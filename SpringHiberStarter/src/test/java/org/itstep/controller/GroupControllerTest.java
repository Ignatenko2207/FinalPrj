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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupControllerTest {
	
	@MockBean
	GroupService groupService;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void createGroupTest(){

		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		Mockito.when(groupService.createAndUpdateGroup(Mockito.<Group>any())).thenReturn(group);
		Mockito.when(groupService.isUnique(Mockito.<Group>any())).thenReturn(true);
		Mockito.when(groupService.getGroup(Mockito.<String>any())).thenReturn(null);
		groupService.createAndUpdateGroup(group);
		Mockito.verify(groupService, Mockito.times(1)).createAndUpdateGroup(group);		
	}
	
	@Test
	public void updateGroupTest(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		Mockito.when(groupService.createAndUpdateGroup(Mockito.<Group>any())).thenReturn(group);
		Mockito.when(groupService.isUnique(Mockito.<Group>any())).thenReturn(true);
		Mockito.when(groupService.getGroup(Mockito.<String>any())).thenReturn(group);
		groupService.createAndUpdateGroup(group);
		Mockito.verify(groupService, Mockito.times(1)).createAndUpdateGroup(group);
	}
	
	@Test
	public void getGroupTest(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		Mockito.when(groupService.getGroup(Mockito.anyString())).thenReturn(group);
		groupService.getGroup(group.getGroupName());
		Mockito.verify(groupService, Mockito.times(1)).getGroup(Mockito.<String>any());
	}
	

	
	@Test
	public void deleteGroup(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		Mockito.doNothing().when(groupService).deleteGroup(Mockito.<String>any());
		groupService.deleteGroup(group.getGroupName());
		Mockito.verify(groupService, Mockito.times(1)).deleteGroup(Mockito.<String>any());
	}
	
	@Test
	public void getGroupListTest(){
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		List<Group> groupList = Arrays.asList();
		Mockito.when(groupService.findAllGroupsByCourse(Mockito.anyInt())).thenReturn(groupList);
		groupService.findAllGroupsByCourse(group.getCourse());		
		Mockito.verify(groupService, Mockito.times(1)).findAllGroupsByCourse(Mockito.anyInt());
	}
	
}
