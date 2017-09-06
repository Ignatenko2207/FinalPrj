package org.itstep.dao.pojo;

import java.security.spec.EncodedKeySpec;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class User {
	@Column(name = "FULL_NAME", unique= false, nullable = false)
	private String fullName;
	@Id
	@Column(name = "LOGIN", unique= true)
	private String login;
	@Column(name = "PASSWORD", unique= true, nullable = false)
	private String password;
}
