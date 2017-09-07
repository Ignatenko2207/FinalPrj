package org.itstep.service;


import org.itstep.dao.TeacherDAO;
import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDAO teacherDAO;


    @Override
    public void createAndUpdate(Teacher teacher) {
        teacherDAO.saveAndFlush(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherDAO.delete(teacher);
    }

    @Override
    public List<Teacher> getAllBySubject(String subject) {
        return teacherDAO.getAllBySubject(subject);
    }

    @Override
    public List<Teacher> getAllByGroup(String groups) {
        return teacherDAO.getAllByGroup(groups);
    }

}
