package org.itstep.service;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.itstep.dao.pojo.Student;
import org.springframework.data.jpa.repository.Query;

public interface StudentSevice {

	public Student getStudent(String login);
	
	public Student createAndUpdateStudent(Student student);
	
	public void deleteStudent(Student student);

	@Query(value = "SELECT * FROM STUDENTS WHERE GROUP = ?1", nativeQuery = true)
	public List<Student> findStudentsByGroup(String group);
	
	@Query(value = "SELECT * FROM STUDENTS INNER JOIN Groups ON COURSE = ?1", nativeQuery = true)
	public List<Student> findAllStudentsByCourse(Integer course);
}
