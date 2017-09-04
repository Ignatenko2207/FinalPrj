package org.itstep.dao.pojo;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student extends User {

    private String groupId;
    private int course;

    public Student(String login, String password, String firstName, String lastName, String groupId, int course) {
        super(login, password, firstName, lastName);
        this.groupId = groupId;
        this.course = course;
    }
}
