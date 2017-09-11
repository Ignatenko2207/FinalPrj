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
    @Column(name="ID" ,nullable = false)
    private long id;
    @Column(name = "START_TIME",nullable = false)
    private long startTime;
    @Column(name="DURATION" ,nullable = false)
    private String duration;
    @Column(name = "GROUP" ,nullable = false)
    private String group;
    @Column(name ="SUBJECT" ,nullable = false)
    private String subject;
    @Column(name = "ROOM" ,nullable = false)
    private String room;
    @Column(name = "TEACHER" ,nullable = false)
    private String teacher;


    public Lesson(long startTime, String duration, String group, long id, String subject, String room, String teacher) {
        this.startTime = startTime;
        this.duration = duration;
        this.group = group;
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.teacher = teacher;
    }


}
