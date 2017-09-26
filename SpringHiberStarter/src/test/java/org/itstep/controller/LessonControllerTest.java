package org.itstep.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.pojo.Lesson;
import org.itstep.service.LessonService;
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
public class LessonControllerTest {
	
	@MockBean
	private LessonService service;
	
	@InjectMocks
	private LessonController controller;
	
	@Spy
	List<Lesson> lessons;
	
	
	ResponseEntity<Lesson> responseEntity;
	ResponseEntity<List<Lesson>> responseEntityList;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		lessons = new ArrayList<Lesson>(Arrays.asList(
				new Lesson(new Time(10,12,00).getTime(), (long) 2400000, "JayGold", "14pv5", "12", "Java"),
				new Lesson(new Time(11,12,00).getTime(), (long) 2400000, "Kipelov", "15pv5", "14", "Metal"),
				new Lesson(new Time(12,12,00).getTime(), (long) 2400000, "StrausTrup", "16pv5", "16", "C++"),
				new Lesson(new Time(12,12,00).getTime(), (long) 2400000, "JayGold", "16pv5", "16", "C#")
		));
	}
	
	@Test
	public void getLessonTest() {
		Lesson lesson= lessons.get(0);
		when(service.getLesson(lesson.getLessonId())).thenReturn(lesson);
		responseEntity = controller.getLesson(lesson.getLessonId());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void createLessonTest() {
		Lesson lesson= lessons.get(0);
		when(service.saveAndUpdate(lesson)).thenReturn(lesson);
		when(service.isUnique(lesson)).thenReturn(true);
		responseEntity = controller.createLesson(lesson);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	
	@Test
	public void updateLessonTest() {
		Lesson lesson= lessons.get(0);
		when(service.saveAndUpdate(lesson)).thenReturn(lesson);
		responseEntity = controller.updateLesson(lesson);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	
	@Test
	public void deleteLessonTest() {
		Lesson lesson = lessons.get(1);
		doNothing().when(service).delete(lesson.getLessonId());
		responseEntity = controller.deleteLesson(lesson.getLessonId());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());	
	}

	@Test
	public void getOneByGroupAndStartTimeTest() {
		Lesson lesson= lessons.get(2);
		when(service.getOneByTeacherAndStartTime(lesson.getTeacher(), lesson.getLessonStart())).thenReturn(lesson);
		responseEntity = controller.getOneByTeacherAndStartTime(lesson.getTeacher(), lesson.getLessonStart());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void getOneByTeacherAndStartTimeTest() {
		Lesson lesson= lessons.get(2);
		when(service.getOneByTeacherAndStartTime(lesson.getTeacher(), lesson.getLessonStart())).thenReturn(lesson);
		responseEntity = controller.getOneByTeacherAndStartTime(lesson.getTeacher(), lesson.getLessonStart());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void getLessonsByGroupAndPeriodTest() {
		List<Lesson> returnedlessons = new ArrayList<Lesson>(Arrays.asList(lessons.get(2), lessons.get(3)));
		when(service.getLessonsForGroupForPeriod("16pv5", new Time(12,12,00).getTime(), (long) 2400000)).thenReturn(returnedlessons);
		responseEntityList = controller.getLessonsByGroupAndPeriod("16pv5", new Time(12,12,00).getTime(), (long) 2400000);
		assertEquals(HttpStatus.OK, responseEntityList.getStatusCode());
	}
	

}
