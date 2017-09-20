package org.itstep.service.impl;

import java.util.List;

import javax.management.Query;

import org.itstep.dao.StudentDAO;
import org.itstep.dao.pojo.Student;
import org.itstep.service.StudentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentSevice{
	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public Student getStudent(String login){
		return studentDAO.findOne(login);
	}

	@Override
	public Student createAndUpdateStudent(Student student){
		return studentDAO.save(student);
	}
	
	@Override
	public void deleteStudent(Student student){
		studentDAO.delete(student.getLogin());
	}
	
	@Override
	public List<Student> findStudentsByGroup(String group){
		return studentDAO.findStudentsByGroup(group);
	}

	@Override
	public List<Student> findAllStudentsByCourse(int course){
		return studentDAO.findAllStudentsByCourse(course);
	}
	
		
		
	
}
