package org.itstep.service.implementation;


import org.itstep.dao.StudentDAO;
import org.itstep.dao.pojo.Student;
import org.itstep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentDAO studentDAO;


    @Override
    public Student findOneByLogin(String login) {
        return studentDAO.findOne(login);
    }

    @Override
    public Student createAndUpdate(Student student) {
        return studentDAO.saveAndFlush(student);
   }
    @Override
    public void delete(Student student){
        studentDAO.delete(student);
    }
    @Override
    public List<Student> getAllByCourse(int course){
        return studentDAO.getAllByCourse(course);
    }
    @Override
    public  List<Student> getAllByGroup(String groups){

        return studentDAO.getAllByGroup(groups);
    }
    @Override
    public boolean isUnique(String student) {
        if (studentDAO.getByLogin(student) != null) {
            return false;
        }

        return true;
    }

}
