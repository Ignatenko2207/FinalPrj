package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TEACHERS")
public class Teacher{
	@Id
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "TEACHER_SUBJECT", nullable = false)
	private String subject;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
}
