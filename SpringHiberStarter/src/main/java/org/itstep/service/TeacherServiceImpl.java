package org.itstep.service;


import org.itstep.dao.TeacherDAO;
import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDAO teacherDAO;


    @Override
    public void createAndUpdate(Teacher teacher) {
        teacherDAO.saveAndFlush(teacher);
    }

}
