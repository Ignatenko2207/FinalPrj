package org.itstep.service;

import org.itstep.dao.StudentDAO;
import org.itstep.dao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

public interface StudentService  {

    public void createAndUpdate(Student student);


}
