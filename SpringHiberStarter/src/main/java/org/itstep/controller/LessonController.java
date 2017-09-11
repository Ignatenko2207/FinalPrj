package org.itstep.controller;


import lombok.extern.slf4j.Slf4j;
import org.itstep.dao.pojo.Lesson;
import org.itstep.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/lesson")
public class LessonController {


    @Autowired
    LessonService lessonService;

     @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<Lesson> createLesson (@RequestBody Lesson lesson){
        if(lessonService.isUnique(lesson)){
          Lesson lessondb =   lessonService.saveAndUpdate(lesson);
            return new ResponseEntity<Lesson>(lessondb,HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<Lesson> updateLesson (@RequestBody Lesson lesson){
        if(!lessonService.isUnique(lesson)){
            Lesson lessondb =   lessonService.saveAndUpdate(lesson);
            return new ResponseEntity<Lesson>(lessondb,HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @GetMapping(value = "/get-one-by-group-and-time")
    public ResponseEntity<Lesson> getOneByGroupAndStartTime (String group,Long startTime){
      Lesson lessonDB = lessonService.getOneByGroupAndStartTime(group,startTime);

      if(lessonDB!=null) {
          return new ResponseEntity<Lesson>(lessonDB, HttpStatus.OK);
      }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }





    @DeleteMapping

    public ResponseEntity deleteGroup(Long lesson) {
        try {
            lessonService.delete(lesson);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}
