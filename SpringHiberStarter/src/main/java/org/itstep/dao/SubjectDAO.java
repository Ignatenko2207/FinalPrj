package org.itstep.dao;

import javax.security.auth.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDAO  extends JpaRepository<Subject, String> {
	
	

}
