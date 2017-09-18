package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/group")
public class GroupController {

	@Autowired
	GroupService groupService;

	@PostMapping
	public ResponseEntity<Group> createGroup(@RequestBody Group group) {
		if(groupService.isUnique(group)) {
			Group groupDB = groupService.createAndUpdateGroup(group);
			if(groupDB == null) {
				return new ResponseEntity<Group>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Group>(groupDB, HttpStatus.CREATED);
		}
		return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Group> updateGroup(@RequestBody Group group) {
		if(!groupService.isUnique(group)) {
			Group groupDB = groupService.createAndUpdateGroup(group);
			if(groupDB == null) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Group>(groupDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(value = "/get-group")
	public ResponseEntity<Group> getOneGroup(@RequestParam(required = true) String groupName) {
		Group groupDB = groupService.getGroup(groupName);
		if(groupDB == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Group>(groupDB, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-grouplist")
	public ResponseEntity<List<Group>> getOneGroup(@RequestParam(required = true) int course) {
		List<Group> groupList = groupService.findAllByCourse(course);
		return new ResponseEntity<List<Group>>(groupList, HttpStatus.CREATED);

	}

	@DeleteMapping
	public ResponseEntity deleteGroup(@RequestParam(required = true) String groupName) {
		try {
			groupService.deleteGroup(groupName);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
