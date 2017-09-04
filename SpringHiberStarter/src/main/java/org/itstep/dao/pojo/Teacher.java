package org.itstep.dao.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Teacher extends User {

      private String subject;

    public Teacher(String login, String password, String firstName, String lastName, String subject) {
        super(login, password, firstName, lastName);
        this.subject = subject;
    }
}
