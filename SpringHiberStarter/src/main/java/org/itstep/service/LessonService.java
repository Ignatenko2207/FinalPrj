package org.itstep.service;

import java.util.List;

import org.itstep.dao.pojo.Lesson;

public interface LessonService {

	Lesson saveAndUpdate(Lesson lesson);
	
	Lesson getLesson(Long lessonId);
	
	void delete(Long id);

	Lesson getOneByTeacherAndStartTime(String teacher, Long startTime);
	
	List<Lesson> getLessonsForGroupForPeriod(String group, Long start, Long end);

	public boolean isUnique(Lesson lesson);
}
