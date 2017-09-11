package org.itstep.dao;

import java.util.List;

import org.itstep.dao.pojo.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDAO extends JpaRepository<Lesson, Long> {

	@Query(value = "SELECT * FROM LESSONS WHERE GROUP = ?1 AND START_TIME = ?2", nativeQuery = true)
	Lesson getOneByGroupAndStartTime(String group, Long startTime);
	
	@Query(value = "SELECT * FROM LESSONS WHERE TECHER = ?1 AND START_TIME = ?2", nativeQuery = true)
	Lesson getOneByTeacherAndStartTime(String teacher, Long startTime);
	
	@Query(value = "SELECT * FROM LESSONS WHERE GROUP = ?1 AND START_TIME = ?2", nativeQuery = true)
	List<Lesson> getLessonsForGroupForDay(String group, Long startDay, Long endDay);

	List<Lesson> getLessonsForCourseForDay(Integer course, Long startDay, Long endDay);

	List<Lesson> getLessonsForGroupForWeek(String group, Long startWeek, Long endWeek);

	@Query(value = "SELECT * FROM LESSONS AS L INNER JOIN GROUP ON L.GROUP = GROUP.GROUP_NAME "
			+ "WHERE GROUP.COURSE = ?1 AND L.START_DAY > ?2 AND L.START_DAY < ?3 ")
	List<Lesson> getLessonsForCourseForWeek(Integer course, Long startWeek, Long endWeek);

	List<Lesson> getLessonsForTeacherForDay(String teacher, Long startDay, Long endDay);

	List<Lesson> getLessonsForTeacherForWeek(String teacher, Long startWeek, Long endWeek);
	
	Lesson getOneBySubjectAndStartTime(String subject, Long startTime);
}
