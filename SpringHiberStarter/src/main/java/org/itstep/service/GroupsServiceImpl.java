package org.itstep.service;

import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupsServiceImpl implements GroupsService {

    @Autowired
    GroupDAO groupsDAO;

    @Override
    public void createAndUpdate(Group group) {
        groupsDAO.saveAndFlush(group);
    }

    @Override
    public void delete(Group group) {
        groupsDAO.delete(group);
    }


    @Override
    public void getAllByCourse(int course){
        groupsDAO.getAllByCourse(course);
    }



}
