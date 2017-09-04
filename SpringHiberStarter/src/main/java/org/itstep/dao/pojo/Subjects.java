package org.itstep.dao.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Subjects {

    private String name;


    public Subjects(String name) {
        this.name = name;
    }
}
