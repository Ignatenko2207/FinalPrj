package org.itstep.dao;

import java.util.List;

import org.itstep.dao.pojo.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDAO extends JpaRepository<Lesson, Long> {

	@Query(value = "SELECT * FROM LESSONS WHERE GROUP_NAME=?1 AND START_TIME=?2", nativeQuery = true)
	Lesson getOneByGroupAndStartTime(String group, Long startTime);
	
	@Query(value = "SELECT * FROM LESSONS WHERE TEACHER=?1 AND START_TIME=?2", nativeQuery = true)
	Lesson getOneByTeacherAndStartTime(String teacher, Long startTime);
	
	@Query(value = "SELECT * FROM LESSONS WHERE GROUP_NAME = ?1 AND START_TIME = ?2", nativeQuery = true)
	List<Lesson> getLessonsForGroupForPeriod(String group, Long start, Long end);
	
	@Query(value = "SELECT * FROM LESSONS AS L INNER JOIN GROUP ON L.GROUP = GROUPS.GROUP_NAME "
			+ "WHERE GROUPS.COURSE = ?1 AND L.START_DAY > ?2 AND L.START_DAY < ?3 ",  nativeQuery = true)
	List<Lesson> getLessonsForCourseForPeriod(Integer course, Long start, Long end);

	@Query(value = "SELECT * FROM LESSONS WHERE TEACHER = ?1 AND START_DAY>?1 AND END_DAY<?3",  nativeQuery = true)
	List<Lesson> getLessonsForPeriod(String teacher, Long start, Long end);
}
