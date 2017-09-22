package org.itstep.dao;

import org.itstep.dao.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO  extends JpaRepository<Student,String>{
//TODO   create Queryes and crud operations


    @Query(value = "SELECT * FROM STUDENTS INNER JOIN GROUPS ON COURSE = ?1", nativeQuery = true)
    public List<Student> getAllByGroup(String group);
    @Query(value = "SELECT * FROM STUDENTS WHERE COURSE =?1",nativeQuery = true)
    public List<Student> getAllByCourse(int course);   // SQL join request
    @Query(value = "SELECT * FROM STUDENTS WHERE LOGIN =?1",nativeQuery = true)
    public List<Student> getByLogin(String login);



}
