package org.itstep.dao;

import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDAO extends JpaRepository<Teacher,String> {


    public List<Teacher> getAllByGroup(String group);

    public List<Teacher> getAllBySubject(String subject);

    public List<Teacher> getByLogin(String login);   // SQL join request

}
