package org.itstep.service;

import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Lesson;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonService {


    Lesson saveAndUpdate (Lesson lesson);

     void delete (Long id);


 //   @Query(value = "SELECT * FROM LESSONS WHERE GROUP = ?1 AND STARTTIME = ?2",nativeQuery = true)
    List<Lesson> getOneByGroupAndStartTime (String group, Long startTime);

   // @Query(value = "SELECT * FROM LESSONS WHERE TEACHER = ?1 AND STARTTIME = ?2",nativeQuery = true)
    List<Lesson> getLessonsForGroupForDay (String  group,Long startDay);


    List<Lesson> getLessonsForCourseForDay (int  course,Long startDay ,Long endDay);

    // @Query(value = "SELECT * FROM LESSON0S  INNER JOIN GROUPS ON LESSONS.GROUP = GROUP.GROUP_NAME WHERE GROUP.COURSE = ?1  AND   LESSONS.START_DAY  > ?2 AND LESSONS.START_DAY < ?3 ",nativeQuery = true)
    List<Lesson> getLessonsForCourseForWeek (String group,Long startWeek,Long endWeek);

    List<Lesson> getLessonsForGroupForWeek (String  group,Long startWeek);

    List<Lesson> getOneByTeacherAndStartTime (String teacher,Long startTime);

    List<Lesson> getLessonsForTeacherForDay (String  group,Long startDay,Long endDay);

    List<Lesson> getLessonsForTeacherForWeek (int  course,Long startWeek,Long endWeek);

    boolean isUnique(Lesson lesson);


}
