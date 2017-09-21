package org.itstep.dao;


import java.util.List;

import org.itstep.dao.pojo.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDAO extends JpaRepository<Group, String>{
	@Query(value = "SELECT * FROM GROUPS WHERE COURSE = ?1", nativeQuery = true)
	List<Group> findAllGroupsByCourse(int course);
}
