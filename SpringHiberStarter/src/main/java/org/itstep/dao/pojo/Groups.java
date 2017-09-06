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
public class Groups  {
    @Id
    @Column(name="NAME")
    private String name;
    @Column(name="COURCE")
    private String course;


    public Groups(String name, String course) {
        this.name = name;
        this.course = course;
    }
}
