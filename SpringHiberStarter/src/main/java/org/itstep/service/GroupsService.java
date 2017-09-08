package org.itstep.service;

import org.itstep.dao.pojo.Group;

import java.util.List;

public interface GroupsService {

    public Group getGroup(String groupname);

   public Group createAndUpdate(Group group);

  public  Group delete(Group group);

    List<Group> getAllByCourse(int course);
}
