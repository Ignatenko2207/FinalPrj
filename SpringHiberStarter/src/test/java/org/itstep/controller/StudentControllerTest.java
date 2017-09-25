package org.itstep.controller;

import java.util.Arrays;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Student;
import org.itstep.service.StudentService;
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
		studentService.createAndUpdateStudent(student);
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
		studentService.getStudent(student.getLogin());
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
		studentService.deleteStudent(student.getLogin());
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
		studentService.findStudentsByGroup(student.getStudentGroup());
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
		studentService.findAllStudentsByCourse(group.getCourse());
		Mockito.verify(studentService, Mockito.times(1)).findAllStudentsByCourse(Mockito.anyInt());
	}

}
