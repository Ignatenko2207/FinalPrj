package org.itstep.service;

import org.itstep.dao.pojo.Teacher;

import java.util.List;

public interface TeacherService {


    Teacher getTeacher(String login);

    Teacher createAndUpdate(Teacher teacher);

    void deleteTeacher(Teacher teacher);
}
