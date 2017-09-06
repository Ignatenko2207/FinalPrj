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
@Table(name = "STUDENTS")
public class Student extends User {
	@Column(name = "STUDENT_GROUP", unique= true, nullable = false)
	private Integer studentGroup;
}
