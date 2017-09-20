package org.itstep.test.dao;

import static org.junit.Assert.*;

import org.itstep.dao.StudentDAO;
import org.itstep.dao.pojo.Student;
import org.itstep.test.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StudentDAOTest {

 @Autowired
 StudentDAO studentDAO;
 
 @Test
 public void testCreateAndGetAndDelete() {
  Student student = new Student();
  student.setLogin("student1");
  student.setPassword("123456");
  student.setFirstName("Alex Aheyev");
  student.setStudentGroup("someGroup");
  Student studentDB = studentDAO.saveAndFlush(student);
  assertNotNull(studentDB);
  studentDAO.delete(studentDB.getLogin());
  
 }
 
 @Test
 public void testFindStudentsByGroup() {
 }

}