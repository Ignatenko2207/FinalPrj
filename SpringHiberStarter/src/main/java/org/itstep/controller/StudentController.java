package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Lesson;
import org.itstep.dao.pojo.Student;
import org.itstep.service.StudentService;
import org.itstep.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping()
	public ResponseEntity<Student> createStudent(@RequestBody String studentJsonObject) {
		Gson gson = new Gson();
		Student student = gson.fromJson(studentJsonObject, Student.class);
		if (studentService.isUnique(student)) {
			Student studentDB = studentService.createAndUpdateStudent(student);
			return new ResponseEntity<Student>(studentDB, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/get-one-student-by-login")
	public ResponseEntity<Student> getStudent(String studentLogin) {
		Student studentDB = studentService.getStudent(studentLogin);
		if (studentDB != null)
			return new ResponseEntity<Student>(studentDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	
	@PutMapping()
	public ResponseEntity<Student> updateStudent(@RequestBody String studentJsonObject){
		Gson gson = new Gson();
		Student student = gson.fromJson(studentJsonObject, Student.class);
		if(!studentService.isUnique(student)){
			Student studentDB = studentService.createAndUpdateStudent(student);
			return new ResponseEntity<Student>(studentDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping
	public ResponseEntity deleteStudent(@RequestParam(required = true) String login) {
		try {
			studentService.deleteStudent(login);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-students-by-group")
	public ResponseEntity<List<Student> > getStudentsByGroup(String group) {
		List<Student>  studentsDB = studentService.findStudentsByGroup(group);
		if (studentsDB != null)
			return new ResponseEntity<List<Student> >(studentsDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/get-students-by-course")
	public ResponseEntity<List<Student> > getStudentsByCourse(Integer course) {
		List<Student> studentsDB = studentService.findAllStudentsByCourse(course);
		if (studentsDB != null)
			return new ResponseEntity<List<Student> >(studentsDB, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
}
