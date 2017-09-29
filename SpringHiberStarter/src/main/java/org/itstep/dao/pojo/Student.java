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
@Table(name = "STUDENT")
public class Student  {


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

    @Column(name = "COURSE")
    private String course;







  public Student() {


  }
}
