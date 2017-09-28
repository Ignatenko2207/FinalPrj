package org.itstep.dao;

import java.util.List;

import org.itstep.dao.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherDAO extends JpaRepository<Teacher, String>{
	@Query(value ="SELECT * FROM TEACHERS WHERE TEACHER_SUBJECT = ?1", nativeQuery = true)
	public List<Teacher> findTeachersBySubject(String Subject);
}
