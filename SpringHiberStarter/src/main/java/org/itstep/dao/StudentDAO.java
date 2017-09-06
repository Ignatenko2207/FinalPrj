package org.itstep.dao;

import java.util.List;

import org.itstep.dao.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<Student, String>{
	@Query(value = "SELECT * FROM STUDENTS WHERE GROUP = ?1", nativeQuery = true)
	public List<Student> findStudentsByGroup(String group);
	
	@Query(value = "SELECT * FROM STUDENTS INNER JOIN Groups ON COURSE = ?1", nativeQuery = true)
	public List<Student> findAllStudentsByCourse(Integer course);
}
