package org.itstep.service;

import org.itstep.dao.pojo.Teacher;

public interface TeacherService {

	public Teacher getTeacher(String login);
	
	public Teacher createAndUpdateTeacher(Teacher teacher);
	
	public void deleteTeacher(Teacher teacher);
	
}
