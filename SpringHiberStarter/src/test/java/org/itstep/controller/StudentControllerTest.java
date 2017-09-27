package org.itstep.controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.itstep.service.StudentService;
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
public class StudentControllerTest {
	
	@MockBean
	StudentService studentService;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void createGroupTest(){
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		Mockito.when(studentService.isUnique(Mockito.<Student>any())).thenReturn(true);
		Mockito.when(studentService.createAndUpdateStudent(Mockito.<Student>any())).thenReturn(student);
		
		RequestEntity<Student> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Student>(student, HttpMethod.POST, new URI("/student"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Student> respEntity = testRestTemplate.exchange(reqEntity, Student.class);
		assertEquals(HttpStatus.CREATED, respEntity.getStatusCode());
		
		Mockito.verify(studentService, Mockito.times(1)).createAndUpdateStudent(Mockito.<Student>any());
	}
	
	@Test
	public void getStudentTest(){
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		Mockito.when(studentService.getStudent(Mockito.anyString())).thenReturn(student);
		
		RequestEntity<Student> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Student>(student, HttpMethod.GET, new URI("/student/get-one-student-by-login?studentLogin="+student.getLogin()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Student> respEntity = testRestTemplate.exchange(reqEntity, Student.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(studentService, Mockito.times(1)).getStudent(Mockito.anyString());
	}
	
	@Test
	public void updateStudentTest(){
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		Mockito.when(studentService.isUnique(Mockito.<Student>any())).thenReturn(false);
		Mockito.when(studentService.createAndUpdateStudent(Mockito.<Student>any())).thenReturn(student);
		
		RequestEntity<Student> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Student>(student, HttpMethod.PUT, new URI("/student"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Student> respEntity = testRestTemplate.exchange(reqEntity, Student.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		studentService.createAndUpdateStudent(student);
		Mockito.verify(studentService, Mockito.times(1)).createAndUpdateStudent(student);
	}
	
	@Test
	public void deleteStudentTest(){
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		Mockito.doNothing().when(studentService).deleteStudent(Mockito.anyString());
		
		RequestEntity<Student> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Student>(student, HttpMethod.DELETE, new URI("/student?login="+student.getLogin()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Student> respEntity = testRestTemplate.exchange(reqEntity, Student.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(studentService, Mockito.times(1)).deleteStudent(Mockito.anyString());
	}
	
	@Test
	public void getStudentsByGroup(){
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		List<Student> students = Arrays.asList(student);
		Mockito.when(studentService.findStudentsByGroup(Mockito.anyString())).thenReturn(students);
		
		RequestEntity<List<Student>> reqEntity = null;
		try {
			reqEntity = new RequestEntity<List<Student>>(students, HttpMethod.GET, new URI("/student/get-students-by-group?group="+student.getStudentGroup()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Student>> respEntity = testRestTemplate.exchange(reqEntity, new ParameterizedTypeReference<List<Student>>() {
		});
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(studentService, Mockito.times(1)).findStudentsByGroup(Mockito.anyString());
	}
	
	@Test
	public void getStudentsByCourse(){
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		
		Group group = new Group();
		group.setCourse(1);
		group.setGroupName("groupName");
		
		List<Student> students = Arrays.asList(student);
		Mockito.when(studentService.findAllStudentsByCourse(Mockito.anyInt())).thenReturn(students);
		
		RequestEntity<List<Student>> reqEntity = null;
		try {
			reqEntity = new RequestEntity<List<Student>>(students, HttpMethod.GET, new URI("/student/get-students-by-course?course="+group.getCourse()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Student>> respEntity = testRestTemplate.exchange(reqEntity, new ParameterizedTypeReference<List<Student>>() {
		});
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(studentService, Mockito.times(1)).findAllStudentsByCourse(Mockito.anyInt());
	}

}
