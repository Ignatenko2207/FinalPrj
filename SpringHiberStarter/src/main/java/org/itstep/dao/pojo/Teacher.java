package org.itstep.dao.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@Getter
@Entity
@Table(name = "TEACHER")
public class Teacher extends User {

        @Column(name = "SUBJECT")
      private String subject;

    public Teacher(String login, String password, String firstName, String lastName, String subject) {
        super(login, password, firstName, lastName);
        this.subject = subject;
    }
}
