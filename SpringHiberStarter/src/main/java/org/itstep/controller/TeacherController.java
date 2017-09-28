package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Teacher;
import org.itstep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService; 
	
	@GetMapping(value="/get-one-by-login")
	public ResponseEntity<Teacher> getTeacher(String login){
		Teacher teacherInDb = teacherService.getTeacher(login);
		if(teacherInDb != null)
			return new ResponseEntity<Teacher>(teacherInDb, HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping()
	public ResponseEntity<Teacher> createTeacher(Teacher teacher){
		if(teacherService.isUnique(teacher)) {
			Teacher teacherInDb = teacherService.createAndUpdateTeacher(teacher);
			if(teacherInDb != null)
				return new ResponseEntity<Teacher>(teacherInDb, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST); 
	}
	
	@PutMapping()
	public ResponseEntity<Teacher> updateTeacher(Teacher teacher){
		if(!teacherService.isUnique(teacher)) {
			Teacher teacherInDb = teacherService.createAndUpdateTeacher(teacher);
			if(teacherInDb != null)
				return new ResponseEntity<Teacher>(teacherInDb, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping()
	public ResponseEntity deleteTeacher(String login) {
		try {
			teacherService.deleteTeacher(login);
		}catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping(value="/find-teachers-by-subject")
	public ResponseEntity<List<Teacher>> findTeacherBySubject(String subject){
		List<Teacher> teachersInDb = teacherService.findTeacherBySubject(subject);
		if(teachersInDb != null)
			return new ResponseEntity<List<Teacher>>(teachersInDb, HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
