package org.itstep.service;

import java.util.List;

import org.itstep.dao.pojo.Lesson;

public interface LessonService {

	Lesson saveAndUpdate(Lesson lesson);
	
	void delete(Long id);
	
	Lesson getOneByGroupAndStartTime(String group, Long startTime);
	
	Lesson getOneByTeacherAndStartTime(String teacher, Long startTime);
	
	List<Lesson> getLessonsForGroupForDay(String group, Long startDay, Long endDay);

	List<Lesson> getLessonsForCourseForDay(Integer course, Long startDay, Long endDay);

	List<Lesson> getLessonsForGroupForWeek(String group, Long startWeek, Long endWeek);

	List<Lesson> getLessonsForCourseForWeek(Integer course, Long startWeek, Long endWeek);

	List<Lesson> getLessonsForTeacherForDay(String teacher, Long startDay, Long endDay);

	List<Lesson> getLessonsForTeacherForWeek(String teacher, Long startWeek, Long endWeek);
	
	public boolean isUnique(Lesson lesson);
}
