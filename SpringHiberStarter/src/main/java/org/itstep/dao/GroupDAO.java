package org.itstep.dao;

import org.itstep.dao.pojo.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupDAO  extends JpaRepository<Group,String>{




    @Query(value = "SELECT * FROM GROUPS WHERE COURSE = ?1",nativeQuery = true)
    List<Group> findAllByCourse(int course);
}
