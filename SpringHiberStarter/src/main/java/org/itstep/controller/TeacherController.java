package org.itstep.controller;


import java.util.List;

import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Teacher;
import org.itstep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
		if(teacherService.isUnique(teacher)){
			Teacher teacherDB = teacherService.createAndUpdateTeacher(teacher);
			if(teacherDB == null){
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Teacher>(teacherDB, HttpStatus.CREATED);
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
		if(!teacherService.isUnique(teacher)){
			Teacher teacherDB = teacherService.createAndUpdateTeacher(teacher);
			if(teacherDB == null){
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
			return new ResponseEntity<Teacher>(teacherDB, HttpStatus.OK);
		
	}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value = "/find-teacher-by-subject")
	public ResponseEntity<List<Teacher>>getOneTeacher(@RequestParam(required = true) String subject){
		List<Teacher> teacherList = teacherService.findTeacherBySubject(subject);
		
		return new ResponseEntity<List<Teacher>>(teacherList, HttpStatus.CREATED);
		
	}
	public ResponseEntity deleteTeacher(@RequestParam(required = true)Teacher teacher){
		teacherService.deleteTeacher(teacher);
		return new ResponseEntity(HttpStatus.OK);
	}
}
