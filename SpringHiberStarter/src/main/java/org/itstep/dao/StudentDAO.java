package org.itstep.dao;

import org.itstep.dao.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO  extends JpaRepository<Student,String>{

    public List<Student> getAllByGroup(String group);

    public List<Student> getAllByCourse(int course);   // SQL join request

}
