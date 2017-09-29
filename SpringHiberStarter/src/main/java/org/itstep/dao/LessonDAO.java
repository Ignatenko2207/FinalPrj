package org.itstep.dao;

import org.hibernate.sql.Select;
import org.itstep.dao.pojo.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LessonDAO extends JpaRepository<Lesson,Long> {

    @Query(value = "SELECT * FROM LESSONS WHERE GROUP_NAME = ?1 AND START_TIME = ?2",nativeQuery = true)
    Lesson getOneByGroupAndStartTime (String group,Long startTime);

    @Query(value = "SELECT * FROM LESSONS WHERE TEACHER = ?1 AND START_TIME = ?2",nativeQuery = true)
    List<Lesson> getLessonsForGroupForPeriod (String  group,Long startTime);

    @Query(value = "SELECT * FROM LESSONS  INNER JOIN GROUPS ON LESSONS.GROUP_NAME = GROUPS.GROUP_NAME WHERE GROUPS.COURSE = ?1  AND   LESSONS.START_TIME  > ?2 AND LESSONS.START_ < ?3 ",nativeQuery = true)
    List<Lesson> getLessonsForCourseForPeriod (int group, Long startWeek, Long endWeek);

    @Query(value = "SELECT * FROM LESSONS   WHERE TEACHER = ?1 AND   START_TIME  > ?2 AND START_TIME < ?3 ",nativeQuery = true)
   Lesson  getLessonForTeacherForPeriod (String Teacher,Long startPeriod);

    @Query(value = "SELECT * FROM LESSONS WHERE SUBJECT = ?1 AND START_TIME = ?2",nativeQuery = true)
    List<Lesson> getOneBySubjectAndStartTime(String subject , Long startTime);

    @Query(value = "SELECT * FROM LESSONS WHERE TEACHER = ?1 AND START_TIME = ?2",nativeQuery = true)
    List<Lesson> getLessonsForTeacherForPeriod(String teacher, Long start);
}
