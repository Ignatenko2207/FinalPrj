package org.itstep.controller;

import org.itstep.dao.pojo.Lesson;
import org.itstep.service.LessonService;
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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/lesson")
public class LessonController {

	@Autowired
	LessonService lessonService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
		if (lessonService.isUnique(lesson)) {
			Lesson lessonDB = lessonService.saveAndUpdate(lesson);
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson) {
		if (!lessonService.isUnique(lesson)) {
			Lesson lessonDB = lessonService.saveAndUpdate(lesson);
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/get-one-by-group-and-time")
	public ResponseEntity<Lesson> getOneByGroupAndStartTime(String group, Long startTime) {
		Lesson lessonDB = lessonService.getOneByGroupAndStartTime(group, startTime);
		if (lessonDB != null)
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-one-by-teacher-and-time")
	public ResponseEntity<Lesson> getOneByTeacherAndStartTime(String teacher, Long startTime) {
		Lesson lessonDB = lessonService.getOneByTeacherAndStartTime(teacher, startTime);
		if (lessonDB != null)
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
