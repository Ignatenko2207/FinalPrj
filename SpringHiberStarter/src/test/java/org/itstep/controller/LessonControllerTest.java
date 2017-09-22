package org.itstep.controller;


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
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LessonControllerTest {
	
	@MockBean
	LessonDAO lessonDAO;
	
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
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		Mockito.when(lessonService.saveAndUpdate(Mockito.<Lesson>any())).thenReturn(null);
		Mockito.when(lessonService.isUnique(Mockito.<Lesson>any())).thenReturn(true);
		Mockito.when(lessonDAO.findOne(Mockito.<Long>any())).thenReturn(null);
		lessonService.saveAndUpdate(lesson);
		Mockito.verify(lessonService , Mockito.times(1)).saveAndUpdate(Mockito.<Lesson>any());
		lessonService.delete(lesson.getLessonId());
	}
	
	@Test
	public void testUpdateLesson() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		Mockito.when(lessonService.saveAndUpdate(Mockito.<Lesson>any())).thenReturn(null);
		Mockito.when(lessonService.isUnique(Mockito.<Lesson>any())).thenReturn(true);
		Mockito.when(lessonDAO.findOne(Mockito.<Long>any())).thenReturn(null);
		lessonService.saveAndUpdate(lesson);
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
		Mockito.when(lessonDAO.findOne(Mockito.<Long>any())).thenReturn(lesson);
		lessonDAO.findOne(lesson.getLessonId());
		Mockito.verify(lessonDAO, Mockito.times(1)).findOne(Mockito.<Long>any());
		
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
		Mockito.doNothing().when(lessonService).delete(Mockito.<Long>any());
		lessonService.delete(lesson.getLessonId());
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
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsByTeacherAndStartTime(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(lessons);
		lessonService.getLessonsByTeacherAndStartTime(lesson.getTeacher(), lesson.getLessonStart());
		Mockito.verify(lessonService, Mockito.times(1)).getLessonsByTeacherAndStartTime(Mockito.<String>any(),Mockito.<Long>any());
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
		lesson.setTeacher("The Teacher");
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsByGroupAndStartTime(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(lessons);
		lessonService.getLessonsByGroupAndStartTime(lesson.getGroup(), lesson.getLessonStart());
		Mockito.verify(lessonService, Mockito.times(1)).getLessonsByGroupAndStartTime(Mockito.<String>any(), Mockito.<Long>any());
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
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsForGroupForPeriod(Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(lessons);
		lessonService.getLessonsForGroupForPeriod(lesson.getGroup(),lesson.getLessonStart() ,lesson.getLength());
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
		List<Lesson> lessons = Arrays.asList(lesson);
		Group group = new Group();
		group.setCourse(1);
		group.setGroupName("group");
		Mockito.when(lessonService.getLessonsForCourseForPeriod(Mockito.<Integer>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(lessons);
		lessonService.getLessonsForCourseForPeriod(group.getCourse(), lesson.getLessonStart(), lesson.getLength());
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
		lesson.setTeacher("The Teacher");
		List<Lesson> lessons = Arrays.asList(lesson);
		Mockito.when(lessonService.getLessonsForTeacherForPeriod(Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(lessons);
		lessonService.getLessonsForTeacherForPeriod(lesson.getTeacher(),lesson.getLessonStart() ,lesson.getLength());
		Mockito.verify(lessonService, Mockito.times(1)).getLessonsForTeacherForPeriod(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong());
		
	
	}
}

