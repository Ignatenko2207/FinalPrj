package org.itstep.controller;

import java.util.List;

import org.itstep.dao.GroupDAO;
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

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/group")
public class GroupController {

	@Autowired
	Gson gson;
	
	@Autowired
	GroupService groupService;


	@PostMapping()
	public ResponseEntity<String> createGroup(@RequestBody String groupJsonObject) {
		Group group = gson.fromJson(groupJsonObject, Group.class);
		if (groupService.isUnique(group)) {
			Group groupDB = groupService.createAndUpdateGroup(group);
			String groupDBJsonObject = gson.toJson(groupDB);
			if (groupDB == null) {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<String>(groupDBJsonObject, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

	@PutMapping()
	public ResponseEntity<String> updateGroup(@RequestBody String groupJsonObject) {
		Group group = gson.fromJson(groupJsonObject, Group.class);
		if (!groupService.isUnique(group)) {
			Group groupDB = groupService.createAndUpdateGroup(group);
			String groupDBJsonObject = gson.toJson(groupDB);
			if (groupDB == null) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<String>(groupDBJsonObject, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-group")
	public ResponseEntity<String> getOneGroup(@RequestParam(required = true) String groupName) {
		Group groupDB = groupService.getGroup(groupName);
		String groupDBJsonObject = gson.toJson(groupDB);
		if (groupDB == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(groupDBJsonObject, HttpStatus.OK);
	}

	@GetMapping(value = "/get-group-list-by-course")
	public ResponseEntity<String> getGroupList(@RequestParam(required = true) int course) {
		List<Group> groupList = groupService.findAllGroupsByCourse(course);
		String groupListJsonObject = gson.toJson(groupList);
		return new ResponseEntity<String>(groupListJsonObject, HttpStatus.OK);
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
