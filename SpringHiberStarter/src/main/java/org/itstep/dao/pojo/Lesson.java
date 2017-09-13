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
	@Column(name = "ID", unique= true, nullable = false)
	private Long lessonId;
	@Column(name = "START_TIME", nullable = false)
	private Long lessonStart;
	@Column(name = "LENGTH", nullable = false)
	private Long length;
	@Column(name = "TEACHER", nullable = false)
	private String teacher;
	@Column(name = "GROUP", nullable = false)
	private String group;
	@Column(name = "ROOM", nullable = false)
	private String room;
	@Column(name = "SUBJECT", nullable = false)
	private String subject;
	
	
}
