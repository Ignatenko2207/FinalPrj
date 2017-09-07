package org.itstep.service;

import org.itstep.dao.StudentDAO;
import org.itstep.dao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StudentService  {

    public void createAndUpdate(Student student);


    public void delete(Student student);

    List<Student> getAllByCourse(int course);

    List<Student> getAllByGroup(String groups);
}
