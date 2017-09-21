package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StudentServiceTest {

	@Test
	public void testGetStudent() {
	}

	@Test
	public void testCreateAndUpdateStudent() {
	}

	@Test
	public void testDeleteStudent() {
	}

	@Test
	public void testFindStudentsByGroup() {
	}

	@Test
	public void testFindAllStudentsByCourse() {
	}

}
