package org.itstep.dao;

import java.util.List;

import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherDAO extends JpaRepository<Teacher, String>{
	
	@Query(value = "SELECT * FROM GROUPS WHERE TEACHER = ?1", nativeQuery = true)
	public List<Group> findGroupsByTeacher(Teacher teacher);
	
}
