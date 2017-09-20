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
@Table(name = "LESSONS")
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



    public Lesson() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
