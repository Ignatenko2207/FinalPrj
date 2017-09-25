package org.itstep.service;

import static org.junit.Assert.*;

import java.util.List;

import org.itstep.App;
import org.itstep.dao.GroupDAO;
import org.itstep.dao.LessonDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Lesson;
import org.itstep.service.impl.GroupServiceImpl;
import org.itstep.service.impl.LessonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class LessonServiceTest {
	
// Lesson creator
//	Lesson lesson = new Lesson();
//	lesson.setLessonId(1l);
//	lesson.setGroup("group");
//	lesson.setLength(22l);
//	lesson.setLessonStart(0l);
//	lesson.setRoom("room");
//	lesson.setSubject("subject");
//	lesson.setTeacher("The Teacher");
	
	@Autowired
	LessonServiceImpl lessonServiceImpl;
	@Autowired
	GroupServiceImpl groupServiceImpl;
	@Autowired
	GroupDAO groupDAO;
	@Test
	public void testSaveAndUpdate() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		Lesson lessonDB = lessonServiceImpl.saveAndUpdate(lesson);
		assertNotNull(lessonDB);
		Lesson lessonDBChecker = lessonServiceImpl.getLesson(lessonDB.getLessonId());
		assertNotNull(lessonDBChecker);
		assertEquals(lessonDB.getLessonId(), lessonDBChecker.getLessonId());
		assertEquals(lessonDB.getLessonId(), lessonDBChecker.getLessonId());
		lessonServiceImpl.delete(lessonDB.getLessonId());
	}

	@Test
	public void testDelete() {
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setGroup("group");
		lesson.setLength(22l);
		lesson.setLessonStart(0l);
		lesson.setRoom("room");
		lesson.setSubject("subject");
		lesson.setTeacher("The Teacher");
		Lesson lessonDB = lessonServiceImpl.saveAndUpdate(lesson);
		Long id  = lessonDB.getLessonId();
		lessonServiceImpl.delete(id);
		assertNull(lessonServiceImpl.getLesson(id));
		
	}

	@Test
	public void testLessonsByGroupAndStartTime() {
		Lesson lesson = new Lesson();
		lesson.setGroup("groupzzz");
		lesson.setLength(22l);
		lesson.setLessonStart(400l);
		lesson.setRoom("room321");
		lesson.setSubject("chemistry");
		lesson.setTeacher("The Teacher Z");
		Lesson lessonDB = lessonServiceImpl.saveAndUpdate(lesson);
		assertNotNull(lessonDB);
		List<Lesson> lessonsDBCheck = lessonServiceImpl.getLessonsByGroupAndStartTime(lessonDB.getGroup(), lessonDB.getLessonStart());
		assertNotNull(lessonsDBCheck);	
		assertEquals(lessonDB.getLessonStart(),lessonsDBCheck.get(0).getLessonStart());
		assertEquals(lessonDB.getGroup(),lessonsDBCheck.get(0).getGroup());
		lessonServiceImpl.delete(lessonDB.getLessonId());
	}

	@Test
	public void testGetLessonsByTeacherAndStartTime() {
		Lesson lesson = new Lesson();
		lesson.setGroup("groupzzz");
		lesson.setLength(22l);
		lesson.setLessonStart(400l);
		lesson.setRoom("room321");
		lesson.setSubject("chemistry");
		lesson.setTeacher("The Teacher Z");
		Lesson lessonDB = lessonServiceImpl.saveAndUpdate(lesson);
		assertNotNull(lessonDB);
		List<Lesson> lessonsDBCheck = lessonServiceImpl.getLessonsByTeacherAndStartTime(lessonDB.getTeacher(), lessonDB.getLessonStart());
		assertNotNull(lessonsDBCheck);	
		assertEquals(lessonDB.getLessonStart(),lessonsDBCheck.get(0).getLessonStart());
		assertEquals(lessonDB.getTeacher(),lessonsDBCheck.get(0).getTeacher());
		lessonServiceImpl.delete(lessonDB.getLessonId());
	}

	@Test
	public void testGetLessonsForGroupForPeriod() {
		Lesson lesson = new Lesson();
		lesson.setGroup("groupzzz");
		lesson.setLength(10l);
		lesson.setLessonStart(400l);
		lesson.setRoom("room321");
		lesson.setSubject("chemistry");
		lesson.setTeacher("The Teacher Z");
		Lesson lessonDB = lessonServiceImpl.saveAndUpdate(lesson);
		assertNotNull(lessonDB);
		List<Lesson> lessonsDBCheck = lessonServiceImpl.getLessonsForGroupForPeriod(lessonDB.getGroup(), lessonDB.getLessonStart(), lessonDB.getLessonStart()+lessonDB.getLength());
		assertNotNull(lessonsDBCheck);
		long lessonDBEnd = (lessonDB.getLessonStart() + lessonDB.getLength());
		assertEquals(lessonDB.getGroup(),lessonsDBCheck.get(0).getGroup());
		assert(lessonsDBCheck.get(0).getLessonStart()>= lessonDB.getLessonStart());
		assert(lessonsDBCheck.get(0).getLessonStart()<=lessonDBEnd);
		lessonServiceImpl.delete(lessonDB.getLessonId());
	}

	@Test
	public void testGetLessonsForCourseForPeriod() {
		Lesson lesson = new Lesson();
		lesson.setGroup("groupzzz");
		lesson.setLength(10l);
		lesson.setLessonStart(400l);
		lesson.setRoom("room321");
		lesson.setSubject("chemistry");
		lesson.setTeacher("The Teacher Z");
		Group baseGroup = new Group();
		baseGroup.setCourse(1);
		baseGroup.setGroupName(lesson.getGroup());
		groupServiceImpl.createAndUpdateGroup(baseGroup);
		Lesson lessonDB = lessonServiceImpl.saveAndUpdate(lesson);
		assertNotNull(lessonDB);
		Group group = groupDAO.findOne(baseGroup.getGroupName());
		log.info(group.getGroupName());
		List<Lesson> lessonsDBCheck = lessonServiceImpl.getLessonsForCourseForPeriod(group.getCourse(), lessonDB.getLessonStart(), lessonDB.getLessonStart()+lessonDB.getLength());
		assertNotNull(lessonsDBCheck);
		long lessonDBEnd = (lessonDB.getLessonStart() + lessonDB.getLength());
		Integer lessonsDBCheckCourse = groupDAO.findOne(lessonsDBCheck.get(0).getGroup()).getCourse();
		assertEquals(group.getCourse(),lessonsDBCheckCourse);
		assert(lessonsDBCheck.get(0).getLessonStart()>= lessonDB.getLessonStart());
		assert(lessonsDBCheck.get(0).getLessonStart()<=lessonDBEnd);
		lessonServiceImpl.delete(lessonDB.getLessonId());		
		groupServiceImpl.deleteGroup(baseGroup.getGroupName());
	}

	@Test
	public void testGetLessonsForTeacherForPeriod() {
		Lesson lesson = new Lesson();
		lesson.setGroup("groupzzz");
		lesson.setLength(10l);
		lesson.setLessonStart(400l);
		lesson.setRoom("room321");
		lesson.setSubject("chemistry");
		lesson.setTeacher("The Teacher Z");
		Lesson lessonDB = lessonServiceImpl.saveAndUpdate(lesson);
		assertNotNull(lessonDB);
		List<Lesson> lessonsDBCheck = lessonServiceImpl.getLessonsForTeacherForPeriod(lessonDB.getTeacher(), lessonDB.getLessonStart(), lessonDB.getLessonStart()+lessonDB.getLength());
		assertNotNull(lessonsDBCheck);
		long lessonDBEnd = (lessonDB.getLessonStart() + lessonDB.getLength());
		assertEquals(lessonDB.getTeacher(),lessonsDBCheck.get(0).getTeacher());
		assert(lessonsDBCheck.get(0).getLessonStart()>= lessonDB.getLessonStart());
		assert(lessonsDBCheck.get(0).getLessonStart()<=lessonDBEnd);
		lessonServiceImpl.delete(lessonDB.getLessonId());
	}


}
