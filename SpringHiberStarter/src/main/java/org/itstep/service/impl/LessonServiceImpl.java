package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.LessonDAO;
import org.itstep.dao.pojo.Lesson;
import org.itstep.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService{

	@Autowired
	LessonDAO lessonDAO;


	@Override
	public Lesson saveAndUpdate(Lesson lesson) {
		return lessonDAO.saveAndFlush(lesson);
	}

	@Override
	public void delete(Long id) {
		lessonDAO.delete(id);
	}

	@Override
	public Lesson getLesson(Long lessonId) {
		return lessonDAO.findOne(lessonId);
	}

	@Override
	public Lesson getOneByGroupAndStartTime(String group, Long startTime) {
		return lessonDAO.getOneByGroupAndStartTime(group, startTime);
	}

	@Override
	public Lesson getOneByTeacherAndStartTime(String teacher, Long startTime) {
		return lessonDAO.getLessonForTeacherForPeriod(teacher, startTime);
	}

	@Override
	public List<Lesson> getLessonsForGroupForPeriod(String group, Long start) {
		return lessonDAO.getLessonsForGroupForPeriod(group,start);
	}

	@Override
	public List<Lesson> getLessonsForCourseForPeriod(Integer course, Long start, Long end) {
		return lessonDAO.getLessonsForCourseForPeriod(course,start,end);
	}

	@Override
	public List<Lesson> getLessonsForTeacherForPeriod(String teacher, Long start) {
		return lessonDAO.getLessonsForTeacherForPeriod(teacher,start);
	}

	@Override
	public boolean isUnique(Lesson lesson) {
		if(lessonDAO.findOne(lesson.getLessonId()) == null) {
			return true;
		}
		return false;

	}

	@Override
	public Lesson getLesson(Long lessonId) {
		
		return null;
	}
}
