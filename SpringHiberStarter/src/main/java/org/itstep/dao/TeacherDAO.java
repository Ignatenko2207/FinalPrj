package org.itstep.dao;

import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherDAO extends JpaRepository<Teacher,String> {

    @Query(value = "SELECT * FROM TEACHERS INNER JOIN GROUPS ON GROUP = ?1", nativeQuery = true)
    public List<Teacher> getAllByGroup(String group);
    @Query(value = "SELECT * FROM TEACHERS WHERE SUBJECTS = ?1",nativeQuery = true)
    public List<Teacher> getAllBySubject(String subject);
    @Query(value = "SELECT * FROM TEACHERS WHERE LOGIN =?1",nativeQuery = true)
    public List<Teacher> getByLogin(String login);   // SQL join request

}
