package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Subject;
import org.itstep.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@GetMapping(value = "/get-one-by-id")
	public ResponseEntity<Subject> getSubject(String subjectId) {
		Subject subjectDB = subjectService.getSubject(subjectId);
		if (subjectDB != null)
			return new ResponseEntity<Subject>(subjectDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PostMapping()
	public ResponseEntity<Subject> createAndUpdateSubject(@RequestBody Subject subject) {
		
			Subject subjectDB = subjectService.createAndUpdateSubject(subject);
			return new ResponseEntity<Subject>(subjectDB, HttpStatus.CREATED);
		
	}

	

	@DeleteMapping
	public ResponseEntity deleteSubject(@RequestParam(required = true) Subject subject) {
		try {
			subjectService.deleteSubject(subject);;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = "/get-one-by-subject-id")
	public ResponseEntity<Subject> getOneByGroupAndStartTime(String subjectId) {
		Subject subjectDB = subjectService.getSubject(subjectId);
		if (subjectDB != null)
			return new ResponseEntity<Subject>(subjectDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	
		
	}



