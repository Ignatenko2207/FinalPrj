package org.itstep.dao;

import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Repository
public interface TeacherDAO extends JpaRepository<Teacher,String> {

    @Query(value = "SELECT * FROM TEACHERS WHERE SUBJECTS = ?1",nativeQuery = true)
    public List<Teacher> getAllBySubject(String subject);
}
