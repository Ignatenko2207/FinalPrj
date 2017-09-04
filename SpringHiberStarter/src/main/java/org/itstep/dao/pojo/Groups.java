package org.itstep.dao.pojo;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Groups  {
    private String groupId;
    private String description;

    public Groups(String groupId, String description) {
        this.groupId = groupId;
        this.description = description;
    }
}
