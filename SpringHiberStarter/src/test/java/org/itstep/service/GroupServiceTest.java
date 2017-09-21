package org.itstep.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.itstep.App;
import org.itstep.dao.pojo.Group;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupServiceTest {

	@Autowired
	GroupService groupServise;
	
	String name = "19pv5";
	Group group;
	
	@Before
	public void createGroup() {
		group = new Group(name, 3);
	}
	
	@Test
	public void testCreateAndUpdate() {
		Group groupInDb = groupServise.createAndUpdateGroup(group);
		assertNotNull(groupInDb);
		assertEquals(name, groupInDb.getGroupName());
	}

	@Test
	public void testGetOne() {
		
		
	}

	@Test
	public void testFindAllByCourse() {
	}

	@Test
	public void testDelete() {
	}

}
