package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Group;
import org.itstep.dao.pojo.Teacher;
import org.itstep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
	@Autowired
	Gson gson;
	
	@Autowired
	TeacherService teacherService;

	@GetMapping(value = "/get-one-teacher-by-login")
	public ResponseEntity<String> getTeacher(String teacherLogin) {
		Teacher teacherDB = teacherService.getTeacher(teacherLogin);
		String teacherDBJsonObject = gson.toJson(teacherDB);
		if (teacherDB != null)
			return new ResponseEntity<String>(teacherDBJsonObject, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PostMapping()
	public ResponseEntity<String> createTeacher(String teacherJsonObject) {
		Teacher teacher = gson.fromJson(teacherJsonObject, Teacher.class);
		if (teacherService.isUnique(teacher)) {
			Teacher teacherDB = teacherService.createAndUpdateTeacher(teacher);
			String teacherDBJsonObject = gson.toJson(teacherDB);
			if (teacherDB != null)
				return new ResponseEntity<String>(teacherDBJsonObject, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping()
	public ResponseEntity<String> updateTeacher(String teacherJsonObject) {
		Teacher teacher = gson.fromJson(teacherJsonObject, Teacher.class);
		
		if (!teacherService.isUnique(teacher)) {
			Teacher teacherDB = teacherService.createAndUpdateTeacher(teacher);
			String teacherDBJsonObject = gson.toJson(teacherDB);
			return new ResponseEntity<String>(teacherDBJsonObject, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping
	public ResponseEntity deleteTeacher(@RequestParam(required = true) String login) {
		try {
			teacherService.deleteTeacher(login);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

}
