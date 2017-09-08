package org.itstep.dao;

import org.itstep.dao.pojo.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupDAO  extends JpaRepository<Group,String>{

   public List<Group> getAllByCourse(int courese);
}
