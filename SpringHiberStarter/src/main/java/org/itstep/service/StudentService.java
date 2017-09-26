package org.itstep.service;

import java.util.List;

import org.itstep.dao.pojo.Student;

public interface StudentService {

	public Student getStudent(String login);
	
	public Student createAndUpdateStudent(Student student);
	
	public void deleteStudent(Student student);

	public List<Student> findStudentsByGroup(String group);
	
	public List<Student> findAllStudentsByCourse(int course);
	
	public boolean isUnique(Student student);
	
}
