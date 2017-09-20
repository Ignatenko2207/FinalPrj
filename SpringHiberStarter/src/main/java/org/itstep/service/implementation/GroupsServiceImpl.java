package org.itstep.service.implementation;

import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupsServiceImpl implements GroupService{



    @Autowired

    GroupDAO groupDAO;



    @Override

    public Group getGroup(String groupName) {

        return groupDAO.getOne(groupName);

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

        if(groupDAO.getOne(group.getGroupName()) != null) {

            return false;

        }

        return true;

    }




}
