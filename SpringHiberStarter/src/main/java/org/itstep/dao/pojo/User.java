package org.itstep.dao.pojo;

import java.io.Serializable;
import java.security.spec.EncodedKeySpec;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@MappedSuperclass
public class User implements Serializable {
	private static final long serialVersionUID = 6797984300707733576L;
	@Id
	@Column(name = "LOGIN", unique= true)
	private String login;
	@Column(name = "FULL_NAME", unique= false, nullable = false)
	private String fullName;
	@Column(name = "PASSWORD", unique= true, nullable = false)
	private String password;
	public User() {
	}
	
	
}
