package org.itstep.controller;

import java.util.List;

import org.itstep.dao.LessonDAO;
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

import com.google.gson.Gson;

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
	public ResponseEntity<Lesson> createLesson(@RequestBody String lessonJsonObject) {
		Gson gson = new Gson();
		Lesson lesson = gson.fromJson(lessonJsonObject, Lesson.class);
		if (lessonService.isUnique(lesson)) {
			Lesson lessonDB = lessonService.saveAndUpdate(lesson);
			return new ResponseEntity<Lesson>(lessonDB, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	

	@PutMapping()
	public ResponseEntity<Lesson> updateLesson(@RequestBody String lessonJsonObject) {
		Gson gson = new Gson();
		Lesson lesson = gson.fromJson(lessonJsonObject, Lesson.class);
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
	
	@GetMapping(value = "/get-lessons-by-teacher-and-time")
	public ResponseEntity<List<Lesson> > getLessonsByTeacherAndStartTime(String teacher, Long startTime) {
		List<Lesson>  lessonsDB = lessonService.getLessonsByTeacherAndStartTime(teacher, startTime);
		if (lessonsDB != null)
			return new ResponseEntity<List<Lesson> >(lessonsDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-lessons-by-group-and-time")
	public ResponseEntity<List<Lesson> > getLessonsByGroupAndStartTime(String group, Long startTime) {
		List<Lesson> lessonsDB = lessonService.getLessonsByGroupAndStartTime(group, startTime);
		if (lessonsDB != null)
			return new ResponseEntity<List<Lesson>>(lessonsDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}




	// get lessons by course and time period(long values)

	@GetMapping(value = "/get-lessons-by-group-and-period")
	public ResponseEntity<List<Lesson>> getLessonsByGroupAndPeriod(String group, Long startTime, Long length) {
		List<Lesson> lessonsDB = lessonService.getLessonsForGroupForPeriod(group, startTime, length);
		if (lessonsDB != null)
			return new ResponseEntity<List<Lesson>>(lessonsDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}


	@GetMapping(value = "/get-lessons-by-course-and-period")
	public ResponseEntity<List<Lesson>> getLessonsByCourseAndPeriod(int course, Long startTime, Long length) {
		List<Lesson> lessonsDB = lessonService.getLessonsForCourseForPeriod(course, startTime, length);
		if (lessonsDB != null) {
			return new ResponseEntity<List<Lesson>>(lessonsDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

		@GetMapping(value = "/get-lessons-by-teacher-and-period")
		public ResponseEntity<List<Lesson>> getLessonsByTeacherByPeriod(String teacherLogin, Long startTime, Long length) {
			List<Lesson> lessonsDB = lessonService.getLessonsForTeacherForPeriod(teacherLogin, startTime, length);
			if (lessonsDB != null) {
				return new ResponseEntity<List<Lesson>>(lessonsDB, HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
