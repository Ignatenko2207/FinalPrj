package org.itstep.dao.pojo;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "GROUPS")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GROUP_ID", nullable = false, unique = true)
	private Long groupId;
	@Column(name = "GROUP_NAME", unique= false, nullable = false)
	private String groupName;
	@Column(name = "COURSE_NAME", unique= true, nullable = false)
	private String courseName;
}
