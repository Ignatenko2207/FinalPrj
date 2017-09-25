package org.itstep.dao.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Setter
@Getter
@Entity
@Table(name = "GROUPS")
public class Group {
    @Id
    @Column(name = "GROUP_NAME")
    private String groupName;
    @Column(name = "COURCE")
    private int course;




    public Group() {

    }
}
