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
@Table(name = "SUBJECT")
public class Subject {
@Id
@Column(name="SUBJECT_ID")
private String subjectId;
@Column(name="DESCRIPTION_SUBJECT",nullable=false)
private String descriptionSubject;
public Subject() {
}

}
