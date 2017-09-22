package org.itstep.controller;

import java.util.List;

import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/group")
public class GroupController {

	@Autowired
	GroupService groupService;



    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        if(groupService.isUnique(group)) {
            Group groupDB = groupService.createAndUpdateGroup(group);
            if(groupDB == null) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Group>(groupDB, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }




    @PutMapping

    public ResponseEntity<Group> updateGroup(Group group) {

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

    public ResponseEntity<List<Group>> getOneGroup(int course) {

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
