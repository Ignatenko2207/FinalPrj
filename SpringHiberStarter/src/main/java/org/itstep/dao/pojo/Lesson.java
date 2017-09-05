package org.itstep.dao.pojo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lesson {


    private String day;
    private String timeStart;
    private String timeFinish;
    private String group;
    private String title;
    private String teacher;

    public Lesson(String day, String timeStart, String timeFinish, String group, String title, String teacher) {
        this.day = day;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.group = group;
        this.title = title;
        this.teacher = teacher;
    }
}
