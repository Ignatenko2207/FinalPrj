package org.itstep.service.impl;

import java.util.List;

import javax.management.Query;

import org.itstep.dao.StudentDAO;
import org.itstep.dao.pojo.Student;
import org.itstep.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired

	StudentDAO studentDAO;
	


	@Override
	public Student findOneByLogin(String login) {
		return null;
	}

	@Override
	public Student createAndUpdate(Student student) {
		return null;
	}

	@Override
	public void delete(Student student) {

	}

	@Override
	public List<Student> getAllByCourse(int course) {
		return null;
	}

	@Override
	public List<Student> getAllByGroup(String groups) {
		return null;
	}

	@Override
	public boolean isUnique(String student) {
		return false;
	}
}
