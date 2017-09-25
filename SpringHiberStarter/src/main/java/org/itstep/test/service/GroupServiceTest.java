package org.itstep.test.service;

import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;

import static org.junit.Assert.*;

import java.util.List;

import org.itstep.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupServiceTest {
@Autowired
GroupService groupService;


	
	@Test
	public void testCreateAndUpdate() {
		Group group = new Group();
		group.setGroupName("Java321");
		group.setCourse(13);
		Group groupFromDB = groupService.createAndUpdateGroup(group);
		assertNotNull(groupFromDB);
		Group getOne = groupService.getGroup(groupFromDB.getGroupName());
		assertEquals(getOne.getGroupName(),"Java321");
		groupService.deleteGroup(groupFromDB.getGroupName());
		List<Group> groupsFromDB = groupService.findAllByCourse(group.getCourse());
		assertNotNull(groupsFromDB);
		
		
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
