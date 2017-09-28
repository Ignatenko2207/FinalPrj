package org.itstep.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.itstep.App;
import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.itstep.service.TeacherService;
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
public class TeacherControllerTest {

	@MockBean
	private TeacherService service;
	
	@InjectMocks
	private TeacherController controller;
	
	@Spy
	private List<Teacher> teachers;
	
	Teacher teacher;
	
	ResponseEntity<Teacher> responseEntity;
	ResponseEntity<List<Teacher>> responseEntityList;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		teachers = new ArrayList<Teacher>(Arrays.asList(
				new Teacher("les", "olles)9", "Les", "Poderevyansky", "Art writting"),
				new Teacher("bobik", "bob1234", "Bob", "Barker", "Java EE"),
				new Teacher("george01", "gora&8", "George", "Washington", "Java EE")
		));
		teacher = teachers.get(0);
	}
	
	@Test
	public void getTeacherTest() {
		when(service.getTeacher(teacher.getLogin())).thenReturn(teacher);
		responseEntity = controller.getTeacher(teacher.getLogin());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void createdTeacherTest() {
		when(service.createAndUpdateTeacher(teacher)).thenReturn(teacher);
		when(service.isUnique(teacher)).thenReturn(true);
		responseEntity = controller.createTeacher(teacher);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	@Test
	public void updateTeacher() {
		when(service.createAndUpdateTeacher(teacher)).thenReturn(teacher);
		responseEntity = controller.updateTeacher(teacher);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void deleteTeacherTest() {
		doNothing().when(service).deleteTeacher(teacher.getLogin());
		responseEntity = controller.deleteTeacher(teacher.getLogin());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void findTeachersBySubjectTest() {
		List<Teacher> returnedList = new ArrayList<>(Arrays.asList(teachers.get(1), teachers.get(2)));
		String subject = "Java EE";
		when(service.findTeacherBySubject(subject)).thenReturn(returnedList);
		responseEntityList = controller.findTeacherBySubject(subject);
		assertEquals(HttpStatus.OK, responseEntityList.getStatusCode());
	}
}
