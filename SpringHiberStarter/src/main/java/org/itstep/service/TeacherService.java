package org.itstep.service;

import java.util.List;

import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;

public interface TeacherService {

	public Teacher getTeacher(String login);
	
	public Teacher createAndUpdateTeacher(Teacher teacher);
	
	public void deleteTeacher(Teacher teacher);

	public List<Group> findGroupsByTeacher(Teacher teacher);
	
}
