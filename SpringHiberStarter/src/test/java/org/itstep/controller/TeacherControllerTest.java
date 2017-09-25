package org.itstep.controller;

import static org.junit.Assert.*;

import org.itstep.App;
import org.itstep.dao.pojo.Teacher;
import org.itstep.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
		teacherService.getTeacher(teacher.getLogin());
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
		teacherService.createAndUpdateTeacher(teacher);
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
		teacherService.createAndUpdateTeacher(teacher);
		Mockito.verify(teacherService, Mockito.times(1)).createAndUpdateTeacher(Mockito.<Teacher>any());
	}

	@Test
	public void deleteTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setFullName("Alex Aheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		Mockito.doNothing().when(teacherService).deleteTeacher(Mockito.anyString());
		teacherService.deleteTeacher(teacher.getLogin());
		Mockito.verify(teacherService, Mockito.times(1)).deleteTeacher(Mockito.anyString());
	}

}
