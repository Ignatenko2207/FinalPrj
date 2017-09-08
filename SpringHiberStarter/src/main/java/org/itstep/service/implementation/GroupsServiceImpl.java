package org.itstep.service.implementation;

import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupsServiceImpl implements GroupService {

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
    public String delete(String groupName) {
        groupsDAO.delete(groupName);
       return groupName;
    }


    @Override
    public List<Group> getAllByCourse(int course){
        return   groupsDAO.getAllByCourse(course);

    }
    @Override
    public boolean isUnique (Group group){
        if (groupsDAO.getOne(group.getGroupName())!=null){
            return false;
        }



    }



}
