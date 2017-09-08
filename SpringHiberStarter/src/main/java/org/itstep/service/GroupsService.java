package org.itstep.service;

import org.itstep.dao.pojo.Group;

public interface GroupsService {
    void createAndUpdate(Group group);

    void delete(Group group);

    void getAllByCourse(int course);
}
