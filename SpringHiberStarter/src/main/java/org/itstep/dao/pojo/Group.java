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
@Table(name = "GROUPS")
public class Group{
	
	@Id
	@Column(name = "GROUP_NAME", nullable = false)
	private String groupName;
	
	@Column(name = "COURSE", nullable = false)
	private int course;

	public Group() {
	}
}
