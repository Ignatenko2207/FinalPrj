package org.itstep.service;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.itstep.dao.pojo.Student;
import org.springframework.data.jpa.repository.Query;

public interface StudentSevice {

	public Student getStudent(String login);
	
	public Student createAndUpdateStudent(Student student);
	
	public void deleteStudent(Student student);

	public List<Student> findStudentsByGroup(String group);
	
	public List<Student> findAllStudentsByCourse(Integer course);
}
