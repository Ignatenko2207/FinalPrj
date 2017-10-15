package org.itstep.service;

import static org.junit.Assert.*;

import java.util.List;

import org.itstep.App;
import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StudentServiceTest {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	GroupService groupService;

//	Student student = new Student();
//	student.setLogin("login");
//	student.setFullName("Alex Aheyev");
//	student.setPassword("password");
//	student.setStudentGroup("group");
	
	@Test
	public void testGetStudent() {
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		studentService.createAndUpdateStudent(student);
		Student studentDB = studentService.getStudent(student.getLogin());
		assertEquals(student.getLogin(), studentDB.getLogin());
		studentService.deleteStudent(student.getLogin());
	}

	@Test
	public void testCreateAndUpdateStudent() {
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		Student studentDB = studentService.createAndUpdateStudent(student);
		assertEquals(student.getLogin(), studentDB.getLogin());
		studentService.deleteStudent(student.getLogin());
	}

	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		Student studentDB = studentService.createAndUpdateStudent(student);
		studentService.deleteStudent(student.getLogin());
		assertNull(studentService.getStudent(student.getLogin()));
	}

	@Test
	public void testFindStudentsByGroup() {
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		studentService.createAndUpdateStudent(student);
		List<Student> studentsDB = studentService.findStudentsByGroup(student.getStudentGroup());
		assertEquals(student.getStudentGroup(), studentsDB.get(0).getStudentGroup());
		studentService.deleteStudent(student.getLogin());
	}

	@Test
	public void testFindAllStudentsByCourse() {
		Student student = new Student();
		student.setLogin("login");
		student.setFullName("Alex Aheyev");
		student.setPassword("password");
		student.setStudentGroup("group");
		studentService.createAndUpdateStudent(student);
		

		Group group = new Group();
		group.setCourse(923894);
		group.setGroupName("group");
		groupService.createAndUpdateGroup(group);
		
		Group groupDB = groupService.getGroup(student.getStudentGroup());
		List<Student> studentsDB = studentService.findAllStudentsByCourse(group.getCourse());
		assertEquals(student.getLogin(), studentsDB.get(0).getLogin());
		
		studentService.deleteStudent(student.getLogin());
		groupService.deleteGroup(group.getGroupName());
	}

}
