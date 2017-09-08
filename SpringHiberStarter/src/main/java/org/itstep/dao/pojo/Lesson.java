package org.itstep.dao.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "LESSON")
public class Lesson {

    @Id
    @Column(name="ID")
    private String id;
    @Column(name = "START_TIME")
    private long startTime;
    @Column(name="DURATION")
    private String duration;
    @Column(name = "GROUP")
    private String group;
    @Column(name ="SUBJECT")
    private String subject;
    @Column(name = "ROOM")
    private String room;
    @Column(name = "TEACHER")
    private String teacher;

    public Lesson(long startTime, String duration, String group, String id, String subject, String room, String teacher) {
        this.startTime = startTime;
        this.duration = duration;
        this.group = group;
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.teacher = teacher;
    }


}
