package org.itstep.service;

import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;

import java.util.List;

public interface TeacherService {



    public void createAndUpdate(Teacher teacher);


    public void delete(Teacher teacher);

    List<Teacher> getAllBySubject(String subject);

    List<Teacher> getAllByLogin(String login);




}
