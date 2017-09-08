package org.itstep.controller;


import lombok.extern.slf4j.Slf4j;
import org.itstep.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    GroupsService groupsService;














    public ResponseEntity deleteGroup(String groupName){

        try {
            groupsService.delete(groupName);
        }catch(Exception e){
            log.error(e.getMessage());
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity(HttpStatus.OK);

    }



}
