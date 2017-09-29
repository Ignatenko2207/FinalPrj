package org.itstep.service;

import org.itstep.dao.pojo.Group;

import java.util.List;

public interface GroupService {
    Group getGroup(String groupName);

    Group createAndUpdateGroup(Group group);

    void deleteGroup(String groupName);


    List<Group> findAllByCourse(int course);

    boolean isUnique(Group group);
}


