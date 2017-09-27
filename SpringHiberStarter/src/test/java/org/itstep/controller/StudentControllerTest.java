package org.itstep.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.itstep.App;
import org.itstep.dao.pojo.Student;
import org.itstep.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
	@MockBean
	private StudentService service;
	
	@InjectMocks
	private StudentController controller;
	
	@Spy
	List<Student> students;
	
	ResponseEntity<Student> responseEntity;
	ResponseEntity<List<Student>> responseEntityList;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		students = new ArrayList<Student>(Arrays.asList(
				new Student("jayGold", "jQwerty", "Vyacheslav", "Zlatov", "15pv5"),
				new Student("vasPup", "pupk1234", "Vasiliy", "Pupkin", "15pv5"),
				new Student("stepPup", "step1234", "Stepan", "Pupkin", "19pv5")
		));
	}
	
	@Test
	public void getStudentTest() {
		Student student = students.get(0);
		when(service.getStudent(student.getLogin())).thenReturn(student);
		responseEntity = controller.getStudent(student.getLogin());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void createStudentTest() {
		Student student = students.get(0);
		when(service.createAndUpdateStudent(student)).thenReturn(student); 
		when(service.isUnique(student)).thenReturn(true);
		responseEntity = controller.createStudent(student);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	@Test
	public void updateStudentTest() {
		Student student = students.get(0);
		when(service.createAndUpdateStudent(student)).thenReturn(student); 
		responseEntity = controller.updateStudent(student);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void deleteStudentTest() {
		Student student = students.get(0);
		doNothing().when(service).deleteStudent(student.getLogin());
		responseEntity = controller.deleteStudent(student.getLogin());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void findStudentsByGroupTest() {
		List<Student> returnedList = new ArrayList<>(Arrays.asList(students.get(0), students.get(1)));
		String groupName = "15pv5";
		when(service.findStudentsByGroup(groupName)).thenReturn(returnedList);
		responseEntityList = controller.findStudentsByGroup(groupName);
		assertEquals(HttpStatus.OK, responseEntityList.getStatusCode());
	}
}
