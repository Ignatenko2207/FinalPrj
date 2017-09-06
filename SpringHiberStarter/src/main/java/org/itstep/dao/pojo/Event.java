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
@Table(name = "EVENTS")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVENT_ID", unique= true, nullable = false)
	private Long eventId;
	@Column(name = "EVENT_START", unique = false, nullable = false)
	private Long eventStart;
	@Column(name = "EVENT_LENGTH", unique = false, nullable = false)
	private Long eventLength;
	@Column(name = "EVENT_CREATOR", unique = false, nullable = false)
	private User eventCreator;
	@Column(name = "EVENT_GROUP", unique = false, nullable = false)
	private Group eventGroup;
	@Column(name = "EVENT_ROOM", unique = false, nullable = false)
	private String room;
	@Column(name = "EVENT_SUBJECT", unique = false, nullable = false)
	private String subject;
	
	
}
