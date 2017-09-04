package org.itstep.dao.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
@Setter
@Getter
@Entity
public class User {
    @Id
    private String login;

    private String password;
    private String firstName;
    private String lastName;

    public User(String login, String password, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

