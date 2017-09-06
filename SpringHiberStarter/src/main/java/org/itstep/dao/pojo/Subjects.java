package org.itstep.dao.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@Getter
@Entity
@Table(name = "SUBJECTS")
public class Subjects {
    @Column(name = "NAME")
    private String name;


    public Subjects(String name) {
        this.name = name;
    }
}
