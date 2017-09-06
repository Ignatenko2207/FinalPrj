package org.itstep.dao.pojo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lesson {



    private long timeStart;
    private String duration;
    private String group;
    private String id;
    private String subject;
    private String room;

    public Lesson( long timeStart, String duration, String group, String id, String subject, String room) {
        this.timeStart = timeStart;
        this.duration = duration;
        this.group = group;
        this.id = id;
        this.subject = subject;
        this.room = room;
    }


}
