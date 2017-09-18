package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupDAO groupDAO;
	
	@Override
	public Group getGroup(String groupName) {
		return groupDAO.findOne(groupName);
	}

	@Override
	public Group createAndUpdateGroup(Group group) {
		return groupDAO.saveAndFlush(group);
	}

	@Override
	public void deleteGroup(String groupName) {
		groupDAO.delete(groupName);		
	}

	@Override
	public List<Group> findAllByCourse(int course) {
		return groupDAO.findAllByCourse(course);
	}
	
	@Override
	public boolean isUnique(Group group) {
		if(groupDAO.findOne(group.getGroupName()) == null) {
			return true;
		}
		return false;
	}

}
