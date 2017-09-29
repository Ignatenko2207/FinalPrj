package org.itstep.service.impl;

import org.itstep.dao.SubjectDAO;
import org.itstep.dao.pojo.Subject;
import org.itstep.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDAO subjectDAO;

	@Override
	public Subject getSubject(String subjectId) {
		return subjectDAO.findOne(subjectId);
	}

	@Override
	public void deleteSubject(Subject subjectId) {
		subjectDAO.delete(subjectId);

	}

	@Override
	public Subject createAndUpdateSubject(Subject subject) {
		return subjectDAO.saveAndFlush(subject);
	}

}
