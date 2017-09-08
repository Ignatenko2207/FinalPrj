package org.itstep.controller;


import lombok.extern.slf4j.Slf4j;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    GroupService groupService;


    @PostMapping
    public ResponseEntity<Group> createGroup(Group group){
        Group groupDB = groupService.createAndUpdate(group);
        if(groupDB==null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }




    @GetMapping(value = "/get-one")
    public ResponseEntity<Group> getOneGroup(String groupName) {
        Group groupDB = groupService.getGroup(groupName);
        if(groupDB == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Group>(groupDB, HttpStatus.OK);
    }

    @GetMapping(value = "/get-groups")
    public ResponseEntity<List<Group>> getOneGroup(int course) {
        List<Group> groupList = groupService.getAllByCourse(course);
        return new ResponseEntity<List<Group>>(groupList, HttpStatus.CREATED);

    }





    @DeleteMapping
    public ResponseEntity deleteGroup(String groupName){

        try {
            groupService.delete(groupName);
        }catch(Exception e){
            log.error(e.getMessage());
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity(HttpStatus.OK);

    }



}
