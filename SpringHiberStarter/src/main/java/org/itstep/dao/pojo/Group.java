package org.itstep.dao.pojo;

import java.io.Serializable;
import java.util.ArrayList;

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
@Table(name = "GROUPS")
public class Group implements Serializable {
	private static final long serialVersionUID = -3084489932306805115L;
	@Id
	@Column(name = "GROUP_NAME", nullable = false)
	private String groupName;
	@Column(name = "COURSE", nullable = false)
	private Integer course;
	public Group() {
	}
}
