package org.itstep.service.implementation;

import org.itstep.dao.LessonDAO;
import org.itstep.dao.pojo.Lesson;
import org.itstep.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LessonServiceImpl implements LessonService {


    @Autowired
    LessonDAO lessonDAO;

    @Override
    public Lesson saveAndUpdate(Lesson lesson) {
        return null;
    }

    @Override
    public void delete(Long id) {
        lessonDAO.delete(id);
    }

    @Override
    public List<Lesson> getOneByGroupAndStartTime(String group, Long startTime) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsForGroupForDay(String group, Long startDay) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsForCourseForDay(int course, Long startDay, Long endDay) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsForCourseForWeek(String group, Long startWeek, Long endWeek) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsForGroupForWeek(String group, Long startWeek) {
        return null;
    }

    @Override
    public List<Lesson> getOneByTeacherAndStartTime(String teacher, Long startTime) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsForTeacherForDay(String group, Long startDay, Long endDay) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsForTeacherForWeek(int course, Long startWeek, Long endWeek) {
        return null;
    }

    @Override
    public boolean isUnique(Lesson lesson) {

            if (lessonDAO.getOneBySubjectAndStartTime(lesson.getSubject(), lesson.getStartTime()) != null){
              return false;
            }
        return true;
    }

}

