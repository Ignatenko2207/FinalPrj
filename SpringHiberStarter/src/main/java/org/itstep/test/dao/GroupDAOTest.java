package org.itstep.test.dao;



import static org.junit.Assert.*;

import java.util.List;

import org.itstep.App;
import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupDAOTest {
	 @Autowired
	 GroupDAO groupDAO;

	@Test
	public void testFindAllByCourse() {
		
	}

	@Test
	public void testSaveAndGetAndDelete() {
	 Group group = new Group();
	 group.setGroupName("Java321");
     group.setCourse(12);
	 Group groupFromDB = groupDAO.saveAndFlush(group);
	 assertNotNull(groupFromDB);
	 Group getOne = groupDAO.findOne(groupFromDB.getGroupName());
	 assertEquals(getOne.getGroupName(),"Java321");
	 List<Group> findGroup = groupDAO.findAllByCourse(group.getCourse());
	 assertNotNull(findGroup);
	 groupDAO.delete(groupFromDB.getGroupName());
	
	}

}
