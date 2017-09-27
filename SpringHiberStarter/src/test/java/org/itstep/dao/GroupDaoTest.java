package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.App;
import org.itstep.dao.pojo.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupDaoTest {
	
	@Autowired
	GroupDAO groupDAO;

	@Test
	public void testSaveAndDelete() {
		Group group = new Group();
		group.setGroupName("J16");
		group.setCourse(2);
		Group groupDB = groupDAO.saveAndFlush(group);
		assertNotNull(groupDB);
		groupDAO.delete(groupDB.getGroupName());
		
	}

	@Test
	public void testSaveAndGetAndDelete() {
		
	}

}
