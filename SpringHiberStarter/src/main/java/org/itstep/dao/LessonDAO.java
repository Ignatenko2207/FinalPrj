package org.itstep.dao;

import org.hibernate.sql.Select;
import org.itstep.dao.pojo.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LessonDAO extends JpaRepository<Lesson,Long> {


    @Query(value = "SELECT * FROM LESSONS WHERE GROUP = ?1 AND STARTTIME = ?2",nativeQuery = true)
    Lesson getOneByGroupAndStartTime (String group,Long startTime);

    @Query(value = "SELECT * FROM LESSONS WHERE TEACHER = ?1 AND STARTTIME = ?2",nativeQuery = true)
    List<Lesson> getLessonsForGroupForPeriod (String  group,Long startDay);




    @Query(value = "SELECT * FROM LESSON0S  INNER JOIN GROUPS ON LESSONS.GROUP = GROUP.GROUP_NAME WHERE GROUP.COURSE = ?1  AND   LESSONS.START_DAY  > ?2 AND LESSONS.START_DAY < ?3 ",nativeQuery = true)
    List<Lesson> getLessonsForCourseForPeriod (String group,Long startWeek,Long endWeek);



    List<Lesson> getOneByTeacherAndStartTime (String teacher,Long startTime);


    @Query(value = "SELECT * FROM LESSON0S  INNER JOIN GROUPS ON LESSONS.GROUP = GROUP.GROUP_NAME WHERE GROUP.COURSE = ?1  AND   LESSONS.START_DAY  > ?2 AND LESSONS.START_DAY < ?3 ",nativeQuery = true)
    List<Lesson> getLessonsForTeacherForPeriod (int  course,Long startWeek,Long endWeek);

    @Query(value = "SELECT * FROM LESSONS WHERE SUBJECT = ?1 AND STARTTIME = ?2",nativeQuery = true)
    List<Lesson> getOneBySubjectAndStartTime(String subject , Long startTime);

}
