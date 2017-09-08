package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LESSONS")
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LESSON_ID", unique= true, nullable = false)
	private Long lessonId;
	@Column(name = "LESSON_START", nullable = false)
	private Long lessonStart;
	@Column(name = "LESSON_LENGTH", nullable = false)
	private Long length;
	@Column(name = "LESSON_CREATOR", nullable = false)
	private Teacher teacher;
	@Column(name = "LESSON_GROUP", nullable = false)
	private Group group;
	@Column(name = "LESSON_ROOM", length = 4000, nullable = false)
	private String room;
	@Column(name = "LESSON_SUBJECT", nullable = false)
	private String subject;
	
	
}
