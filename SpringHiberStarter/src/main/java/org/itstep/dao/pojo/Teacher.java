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
@Table(name = "TEACHER")
public class Teacher  {

        @Column(name = "SUBJECT")
      private String subject;

    @Id
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name="LEAST_NAME")
    private String lastName;

    @Column(name = "GROUP_ID")
    private String group;


    /*    public Teacher(String login, String password, String firstName, String lastName, String subject) {
        super(login, password, firstName, lastName);
        this.subject = subject;
    }

    public Teacher() {

    }
*/
public Teacher() {

}
}
