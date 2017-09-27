package org.itstep.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Teacher;
import org.itstep.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeacherControllerTest {
	
	@MockBean
	TeacherService teacherService;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	

	@Test
	public void getTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setFullName("Alex Aheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		Mockito.when(teacherService.getTeacher(Mockito.anyString())).thenReturn(teacher);
		
		RequestEntity<Teacher> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Teacher>(teacher, HttpMethod.GET, new URI("/teacher/get-one-teacher-by-login?teacherLogin="+teacher.getLogin()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Teacher> respEntity = testRestTemplate.exchange(reqEntity, Teacher.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(teacherService, Mockito.times(1)).getTeacher(Mockito.anyString());
	}

	@Test
	public void createTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setFullName("Alex Aheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		Mockito.when(teacherService.isUnique(Mockito.<Teacher>any())).thenReturn(true);
		Mockito.when(teacherService.createAndUpdateTeacher(Mockito.<Teacher>any())).thenReturn(teacher);
		
		RequestEntity<Teacher> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Teacher>(teacher, HttpMethod.POST, new URI("/teacher"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Teacher> respEntity = testRestTemplate.exchange(reqEntity, Teacher.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(teacherService, Mockito.times(1)).createAndUpdateTeacher(Mockito.<Teacher>any());
	}

	@Test
	public void updateTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setFullName("Alex Aheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		Mockito.when(teacherService.isUnique(Mockito.<Teacher>any())).thenReturn(false);
		Mockito.when(teacherService.createAndUpdateTeacher(Mockito.<Teacher>any())).thenReturn(teacher);
		
		RequestEntity<Teacher> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Teacher>(teacher, HttpMethod.PUT, new URI("/teacher"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Teacher> respEntity = testRestTemplate.exchange(reqEntity, Teacher.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(teacherService, Mockito.times(1)).createAndUpdateTeacher(Mockito.<Teacher>any());
	}

	@Test
	public void deleteTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setFullName("AlexAheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		Mockito.doNothing().when(teacherService).deleteTeacher(Mockito.anyString());
		
		RequestEntity<Teacher> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Teacher>(teacher, HttpMethod.DELETE, new URI("/teacher?login="+teacher.getLogin()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Teacher> respEntity = testRestTemplate.exchange(reqEntity, Teacher.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(teacherService, Mockito.times(1)).deleteTeacher(Mockito.anyString());
	}

}
