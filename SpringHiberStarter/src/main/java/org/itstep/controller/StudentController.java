package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Student;
import org.itstep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping(value = "/get-one-by-id")
	public ResponseEntity<Student> getStudent(String login) {
		Student studentInDb = studentService.getStudent(login);
		if(studentInDb != null) {
			return new ResponseEntity<Student>(studentInDb, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping()
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		if (studentService.isUnique(student)) {
			Student studentInDb = studentService.createAndUpdateStudent(student);
			return new ResponseEntity<Student>(studentInDb, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping()
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		if (!studentService.isUnique(student)) {
			Student studentInDb = studentService.createAndUpdateStudent(student);
			return new ResponseEntity<Student>(studentInDb, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping()
	public ResponseEntity deleteStudent(@RequestParam(required = true) String login) {
		try {
			studentService.deleteStudent(login);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping(value = "/find-students-by-group")
	public ResponseEntity<List<Student>> findStudentsByGroup(String group){
		List<Student> studentsInDb = studentService.findStudentsByGroup(group);
		if(studentsInDb != null)
			return new ResponseEntity<List<Student>>(studentsInDb, HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/find-students-by-course")
	private ResponseEntity<List<Student>> findAllStudentsByCourse(int course) {
		List<Student> studentsInDb = studentService.findAllStudentsByCourse(course);
		if(studentsInDb != null)
			return new ResponseEntity<List<Student>>(studentsInDb, HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
}
