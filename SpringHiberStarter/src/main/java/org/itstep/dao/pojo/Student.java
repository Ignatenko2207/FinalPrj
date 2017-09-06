package org.itstep.dao.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@Getter
@Entity
@Table(name = "STUDENT")
public class Student extends User {

    @Column(name = "GROUP_ID")
    private String group;


    public Student(String login, String password, String firstName, String lastName, String group) {
        super(login, password, firstName, lastName);
        this.group = group;

    }
}
