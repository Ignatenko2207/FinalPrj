package org.itstep.service;

import org.itstep.dao.pojo.Group;

import java.util.List;

public interface GroupService {

    public Group getGroup(String groupname);

   public Group createAndUpdate(Group group);

  public String delete(String groupName);

    List<Group> getAllByCourse(int course);

    boolean isUnique(Group group);
}
