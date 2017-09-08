package org.itstep.service.implementation;

import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    GroupDAO groupsDAO;

    @Override
    public Group getGroup(String groupName) {
        return groupsDAO.getOne(groupName); //getOne делает выборку из одного елемента базы по исходному указанному типу данных
    }

    @Override
    public Group createAndUpdate(Group group) {
        groupsDAO.saveAndFlush(group);
        return group;
    }

    @Override
    public Group delete(Group group) {
        groupsDAO.delete(group);
        return group;
    }


    @Override
    public List<Group> getAllByCourse(int course){
        groupsDAO.getAllByCourse(course);
        return null;
    }



}
