package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Lesson;
import org.itstep.service.LessonService;
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
@RequestMapping(value = "/lesson")
public class LessonController {

	@Autowired
	LessonService lessonService;

	@GetMapping(value = "/get-one-by-id")
	public ResponseEntity<Lesson> getLesson(Long lessonId) {
		Lesson lessonDB = lessonService.getLesson(lessonId);
		if (lessonDB != null)
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PostMapping()
	public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
		if (lessonService.isUnique(lesson)) {
			Lesson lessonDB = lessonService.saveAndUpdate(lesson);
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PutMapping()
	public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson) {
		if (!lessonService.isUnique(lesson)) {
			Lesson lessonDB = lessonService.saveAndUpdate(lesson);
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping
	public ResponseEntity deleteLesson(@RequestParam(required = true) Long lessonId) {
		try {
			lessonService.delete(lessonId);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = "/get-one-by-teacher-and-time")
	public ResponseEntity<Lesson> getOneByTeacherAndStartTime(String teacher, Long startTime) {
		Lesson lessonDB = lessonService.getOneByTeacherAndStartTime(teacher, startTime);
		if (lessonDB != null)
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-lessons-by-group-and-period")
	public ResponseEntity<List<Lesson>> getLessonsByGroupAndPeriod(String group, Long startTime, Long length) {
		List<Lesson> lessonsDB = lessonService.getLessonsForGroupForPeriod(group, startTime, length);
		if (lessonsDB != null)
			return new ResponseEntity<List<Lesson>>(lessonsDB, HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
