package org.itstep.dao;

import org.itstep.dao.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO  extends JpaRepository<Student,String>{



    @Query(value = "SELECT * FROM STUDENTS INNER JOIN GROUPS ON COURSE = ?1", nativeQuery = true)

    //TODO   create Queryes and crud operations
    public List<Student> getAllByGroup(String group);

    public List<Student> getAllByCourse(int course);   // SQL join request

    public List<Student> getByLogin(String login);

}
