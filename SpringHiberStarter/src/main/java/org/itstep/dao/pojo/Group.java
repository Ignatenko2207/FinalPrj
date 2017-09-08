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
	@Column(name = "GROUP_NAME", nullable = false)
	private String groupName;
	@Column(name = "COURSE", nullable = false)
	private Integer course;
}
