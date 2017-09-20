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
	public Lesson getOneByGroupAndStartTime(String group, Long startTime) {
		return lessonDAO.getOneByGroupAndStartTime(group, startTime);
	}

	@Override
	public Lesson getOneByTeacherAndStartTime(String teacher, Long startTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> getLessonsForGroupForPeriod(String group, Long start, Long end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> getLessonsForCourseForPeriod(Integer course, Long start, Long end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> getLessonsForTeacherForPeriod(String teacher, Long start, Long end) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isUnique(Lesson lesson) {
		if(lessonDAO.getOneByTeacherAndStartTime(lesson.getTeacher(), lesson.getLessonStart()) != null) {
			return false;
		}
		return true;
	}
}
