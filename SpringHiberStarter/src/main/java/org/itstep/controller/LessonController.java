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
	Gson gson;

	@Autowired
	LessonService lessonService;

	@GetMapping(value = "/get-one-by-id")
	public ResponseEntity<String> getLesson(Long lessonId) {
		Lesson lessonDB = lessonService.getLesson(lessonId);
		String lessonDBJsonObject = gson.toJson(lessonDB);
		if (lessonDB != null)
			return new ResponseEntity<String>(lessonDBJsonObject, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PostMapping()
	public ResponseEntity<String> createLesson(@RequestBody String lessonJsonObject) {
		Lesson lesson = gson.fromJson(lessonJsonObject, Lesson.class);
		if (lessonService.isUnique(lesson)) {
			Lesson lessonDB = lessonService.saveAndUpdate(lesson);
			String lessonDBJsonObject = gson.toJson(lessonDB);
			return new ResponseEntity<String>(lessonDBJsonObject, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PutMapping()
	public ResponseEntity<String> updateLesson(@RequestBody String lessonJsonObject) {
		Lesson lesson = gson.fromJson(lessonJsonObject, Lesson.class);
		if (!lessonService.isUnique(lesson)) {
			Lesson lessonDB = lessonService.saveAndUpdate(lesson);
			String lessonDBJsonObject = gson.toJson(lessonDB);
			return new ResponseEntity<String>(lessonDBJsonObject, HttpStatus.OK);
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

	@GetMapping(value = "/get-lessons-by-group-and-time")
	public ResponseEntity<String> getLessonsByGroupAndStartTime(String group, Long startTime) {
		List<Lesson> lessonsDB = lessonService.getLessonsByGroupAndStartTime(group, startTime);
		String lessonsDBJsonObject = gson.toJson(lessonsDB);
		if (lessonsDB != null)
			return new ResponseEntity<String>(lessonsDBJsonObject, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-lessons-by-teacher-and-time")
	public ResponseEntity<String> getLessonsByTeacherAndStartTime(String teacher, Long startTime) {
		List<Lesson> lessonsDB = lessonService.getLessonsByTeacherAndStartTime(teacher, startTime);
		String lessonsDBJsonObject = gson.toJson(lessonsDB);
		if (lessonsDB != null)
			return new ResponseEntity<String>(lessonsDBJsonObject, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-lessons-by-group-and-period")
	public ResponseEntity<String> getLessonsByGroupAndPeriod(String group, Long startTime, Long length) {
		List<Lesson> lessonsDB = lessonService.getLessonsForGroupForPeriod(group, startTime, length);
		String lessonsDBJsonObject = gson.toJson(lessonsDB);
		if (lessonsDB != null)
			return new ResponseEntity<String>(lessonsDBJsonObject, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-lessons-by-course-and-period")
	public ResponseEntity<String> getLessonsByCourseAndPeriod(int course, Long startTime, Long length) {
		List<Lesson> lessonsDB = lessonService.getLessonsForCourseForPeriod(course, startTime, length);
		String lessonsDBJsonObject = gson.toJson(lessonsDB);
		if (lessonsDB != null) {
			return new ResponseEntity<String>(lessonsDBJsonObject, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-lessons-by-teacher-and-period")
	public ResponseEntity<String> getLessonsByTeacherByPeriod(String teacherLogin, Long startTime, Long length) {
		List<Lesson> lessonsDB = lessonService.getLessonsForTeacherForPeriod(teacherLogin, startTime, length);
		String lessonsDBJsonObject = gson.toJson(lessonsDB);
		if (lessonsDB != null) {
			return new ResponseEntity<String>(lessonsDBJsonObject, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
