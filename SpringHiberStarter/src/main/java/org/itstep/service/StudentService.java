package org.itstep.service;

import org.itstep.dao.pojo.Student;

import java.util.List;

public interface StudentService  {

    Student findOneByLogin(String login);

    public Student createAndUpdate(Student student);
    public void delete(Student student);
    List<Student> getAllByCourse(int course);
    List<Student> getAllByGroup(String groups);
    public boolean isUnique(String student);
}
