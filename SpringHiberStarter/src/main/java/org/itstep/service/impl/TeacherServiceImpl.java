package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.TeacherDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Teacher;
import org.itstep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherDAO teacherDAO;

	@Override
	public Teacher getTeacher(String login) {
		return teacherDAO.getOne(login);
	}

	@Override
	public Teacher createAndUpdateTeacher(Teacher teacher) {
		return teacherDAO.saveAndFlush(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		teacherDAO.delete(teacher.getLogin());
		
	}

	@Override
	public List<Group> findGroupsByTeacher(Teacher teacher) {
		return teacherDAO.findGroupsByTeacher(teacher);
	}
}
