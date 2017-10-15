package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.Spring;

import com.zaxxer.hikari.HikariConfig;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TEACHERS")
public class Teacher extends User  {
	
	@Column(name = "TEACHER_SUBJECT", unique= true, nullable = false)
	private String subject;
	
	public Teacher() {
	}
}
