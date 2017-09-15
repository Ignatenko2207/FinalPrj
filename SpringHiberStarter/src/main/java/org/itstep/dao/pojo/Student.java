package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "STUDENTS")
public class Student extends User  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8734580570097125532L;
	
	@Column(name = "STUDENT_GROUP", unique= true, nullable = false)
	private String studentGroup;
	public Student() {
	}
}
