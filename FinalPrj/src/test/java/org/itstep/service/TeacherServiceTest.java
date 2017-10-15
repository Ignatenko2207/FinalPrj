package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.App;
import org.itstep.dao.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TeacherServiceTest {

	// Teacher teacher = new Teacher();
	// teacher.setFullName("Alex Aheyev");
	// teacher.setLogin("login");
	// teacher.setPassword("password");
	// teacher.setSubject("subject");

	@Autowired
	TeacherService teacherService;
	
	@Autowired
	GroupService groupService;

	@Test
	public void testGetTeacher() {
		Teacher teacher = new Teacher();
		teacher.setFullName("Alex Aheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		teacherService.createAndUpdateTeacher(teacher);
		Teacher teacherDB = teacherService.getTeacher(teacher.getLogin());
		assertEquals(teacher.getLogin(), teacherDB.getLogin());
		teacherService.deleteTeacher(teacher.getLogin());

	}

	@Test
	public void testCreateAndUpdateTeacher() {
		Teacher teacher = new Teacher();
		teacher.setFullName("Alex Aheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		Teacher teacherDB = teacherService.createAndUpdateTeacher(teacher);
		assertEquals(teacher.getLogin(), teacherDB.getLogin());
		teacherService.deleteTeacher(teacher.getLogin());
	}

	@Test
	public void testDeleteTeacher() {
		Teacher teacher = new Teacher();
		teacher.setFullName("Alex Aheyev");
		teacher.setLogin("login");
		teacher.setPassword("password");
		teacher.setSubject("subject");
		teacherService.createAndUpdateTeacher(teacher);
		teacherService.deleteTeacher(teacher.getLogin());
		assertNull(teacherService.getTeacher(teacher.getLogin()));
	}


}
