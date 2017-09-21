package org.itstep.service;

import java.util.List;

import org.itstep.dao.pojo.Lesson;
import org.springframework.data.jpa.repository.Query;

public interface LessonService {

	Lesson saveAndUpdate(Lesson lesson);
	
	
	void delete(Long id);
	
	List<Lesson> getLessonsByGroupAndStartTime(String group, Long startTime);
	
	List<Lesson> getLessonsByTeacherAndStartTime(String teacher, Long startTime);
	
	List<Lesson> getLessonsForGroupForPeriod(String group, Long start, Long end);
	
	List<Lesson> getLessonsForCourseForPeriod(Integer course, Long start, Long end);

	List<Lesson> getLessonsForTeacherForPeriod(String teacherLogin, Long start, Long end);
	
	public boolean isUnique(Lesson lesson);
}
