package org.itstep.controller;


import static org.junit.Assert.assertEquals;

import java.awt.print.Pageable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.LessonDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Lesson;
import org.itstep.service.LessonService;
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

import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LessonControllerTest {
	
	@MockBean 
	LessonService lessonService;
		
	@Autowired
	TestRestTemplate testRestTemplate;

//	Lesson lesson = new Lesson();
//	lesson.setLessonId(1l);
//	lesson.setGroup("group");
//	lesson.setLength(22l);
//	lesson.setLessonStart(0l);
//	lesson.setRoom("room");
//	lesson.setSubject("subject");
//	lesson.setTeacher("The Teacher");

	@Test
	public void testCreateLesson() {
		Gson gson = new Gson();
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		lesson.setDescription(" ");
		String lessonJsonObject = gson.toJson(lesson);
		Mockito.when(lessonService.saveAndUpdate(Mockito.<Lesson>any())).thenReturn(null);
		Mockito.when(lessonService.isUnique(Mockito.<Lesson>any())).thenReturn(true);
		Mockito.when(lessonService.getLesson(Mockito.<Long>any())).thenReturn(null);
		
		RequestEntity<String> reqEntity = null;
		try {
			reqEntity = new RequestEntity<String>(lessonJsonObject, HttpMethod.POST, new URI("/lesson"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Lesson> respEntity = testRestTemplate.exchange(reqEntity, Lesson.class);
		assertEquals(HttpStatus.CREATED, respEntity.getStatusCode());
		
		Mockito.verify(lessonService , Mockito.times(1)).saveAndUpdate(Mockito.<Lesson>any());
		lessonService.delete(lesson.getLessonId());
	}
	
	@Test
	public void testUpdateLesson() {
		Gson gson = new Gson();
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		lesson.setDescription(" ");
		String lessonJsonObject = gson.toJson(lesson);
		Mockito.when(lessonService.saveAndUpdate(Mockito.<Lesson>any())).thenReturn(null);
		Mockito.when(lessonService.isUnique(Mockito.<Lesson>any())).thenReturn(false);
		Mockito.when(lessonService.getLesson(Mockito.<Long>any())).thenReturn(null);
		
		RequestEntity<String> reqEntity = null;
		try {
			reqEntity = new RequestEntity<String>(lessonJsonObject, HttpMethod.PUT, new URI("/lesson"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Lesson> respEntity = testRestTemplate.exchange(reqEntity, Lesson.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(lessonService , Mockito.times(1)).saveAndUpdate(Mockito.<Lesson>any());
	}

	@Test
	public void testGetLesson() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		lesson.setDescription(" ");
		Mockito.when(lessonService.getLesson(Mockito.<Long>any())).thenReturn(lesson);

		RequestEntity<Lesson> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Lesson>(lesson, HttpMethod.GET, new URI("/lesson/get-one-by-id?lessonId="+lesson.getLessonId()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Lesson> respEntity = testRestTemplate.exchange(reqEntity, Lesson.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(lessonService, Mockito.times(1)).getLesson(Mockito.<Long>any());
		
	}
	@Test
	public void testDeleteLesson() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		lesson.setDescription(" ");
		Mockito.doNothing().when(lessonService).delete(Mockito.<Long>any());
		
		RequestEntity<Lesson> reqEntity = null;
		try {
			reqEntity = new RequestEntity<Lesson>(lesson, HttpMethod.DELETE, new URI("/lesson?lessonId="+lesson.getLessonId()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Lesson> respEntity = testRestTemplate.exchange(reqEntity, Lesson.class);
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(lessonService, Mockito.times(1)).delete(Mockito.<Long>any());
		
	}

	@Test
	public void testLessonsByGroupAndStartTime() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		lesson.setDescription(" ");
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsByGroupAndStartTime(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(lessons);
		
		RequestEntity<List<Lesson>> reqEntity = null;
		try {
			reqEntity = new RequestEntity<List<Lesson>>(lessons, HttpMethod.GET, new URI("/lesson/get-lessons-by-group-and-time?group="+lesson.getGroup()+"&startTime="+lesson.getLessonStart()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Lesson>> respEntity = testRestTemplate.exchange(reqEntity, new ParameterizedTypeReference<List<Lesson>>() {
		});
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(lessonService, Mockito.times(1)).getLessonsByGroupAndStartTime(Mockito.<String>any(),Mockito.<Long>any());
	}

	@Test
	public void testLessonsByTeacherAndStartTime() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("TheTeacher");
		lesson.setDescription(" ");
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsByTeacherAndStartTime(Mockito.anyString(), Mockito.anyLong())).thenReturn(lessons);
		
		RequestEntity<List<Lesson>> reqEntity = null;
		try {
			reqEntity = new RequestEntity<List<Lesson>>(lessons, HttpMethod.GET, new URI("/lesson/get-lessons-by-teacher-and-time?teacher="+lesson.getTeacher()+"&startTime="+lesson.getLessonStart()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Lesson>> respEntity = testRestTemplate.exchange(reqEntity, new ParameterizedTypeReference<List<Lesson>>() {
		});
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());		
		
		Mockito.verify(lessonService, Mockito.times(1)).getLessonsByTeacherAndStartTime(Mockito.<String>any(), Mockito.<Long>any());
	}

	@Test
	public void testGetLessonsByGroupAndPeriod() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		lesson.setDescription(" ");
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsForGroupForPeriod(Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(lessons);
		
		RequestEntity<List<Lesson>> reqEntity = null;
		try {
			reqEntity = new RequestEntity<List<Lesson>>(lessons, HttpMethod.GET, new URI("/lesson/get-lessons-by-group-and-period?group="+lesson.getGroup()+"&startTime="+lesson.getLessonStart()+"&length="+lesson.getLength()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Lesson>> respEntity = testRestTemplate.exchange(reqEntity, new ParameterizedTypeReference<List<Lesson>>() {
		});
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(lessonService).getLessonsForGroupForPeriod(Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any());
		
	}

	@Test
	public void testGetLessonsByCourseAndPeriod() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		lesson.setDescription(" ");
		List<Lesson> lessons = Arrays.asList(lesson);
		Group group = new Group();
		group.setCourse(1);
		group.setGroupName("group");
		Mockito.when(lessonService.getLessonsForCourseForPeriod(Mockito.<Integer>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(lessons);
		
		RequestEntity<List<Lesson>> reqEntity = null;
		try {
			reqEntity = new RequestEntity<List<Lesson>>(lessons, HttpMethod.GET, new URI("/lesson/get-lessons-by-course-and-period?course="+group.getCourse()+"&startTime="+lesson.getLessonStart()+"&length="+lesson.getLength()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Lesson>> respEntity = testRestTemplate.exchange(reqEntity, new ParameterizedTypeReference<List<Lesson>>() {
		});
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(lessonService, Mockito.times(1)).getLessonsForCourseForPeriod(Mockito.<Integer>any(), Mockito.<Long>any(), Mockito.<Long>any());
	
		
	}

	@Test
	public void testGetLessonsByTeacherByPeriod() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("TheTeacher");
		lesson.setDescription(" ");
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsForTeacherForPeriod(Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(lessons);
		
		RequestEntity<List<Lesson>> reqEntity = null;
		try {
			reqEntity = new RequestEntity<List<Lesson>>(lessons, HttpMethod.GET, new URI("/lesson/get-lessons-by-teacher-and-period?teacherLogin="+lesson.getTeacher()+"&startTime="+lesson.getLessonStart()+"&length="+lesson.getLength()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<List<Lesson>> respEntity = testRestTemplate.exchange(reqEntity, new ParameterizedTypeReference<List<Lesson>>() {
		});
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		Mockito.verify(lessonService, Mockito.times(1)).getLessonsForTeacherForPeriod(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong());
		
	
	}
}

