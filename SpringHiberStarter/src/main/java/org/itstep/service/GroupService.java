package org.itstep.service;

import java.util.List;

import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Group;

public interface GroupService {

	public Group getGroup(String groupName);

	public Group createAndUpdateGroup(Group group);

	public void deleteGroup(String groupName);

	List<Group> findAllByCourse(int course);
	
	public boolean isUnique(Group group);
}
