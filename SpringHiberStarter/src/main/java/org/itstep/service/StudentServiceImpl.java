package org.itstep.service;


import org.itstep.dao.StudentDAO;
import org.itstep.dao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentDAO studentDAO;


    @Override
    public void createAndUpdate(Student student) {
        studentDAO.saveAndFlush(student);
    }


    @Override
    public List<Student> getAllByCourse(int course){
        return studentDAO.getAllByCourse(course);
    }



}
