package org.itstep.service;

import static org.junit.Assert.*;

import java.util.List;

import org.itstep.App;
import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.impl.GroupServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupServiceTest {
	@Autowired
	GroupServiceImpl groupServiceImpl;
	
	
	@Test
	public void testCreateAndUpdate() {
		Group group = new Group();
		group.setCourse(1);
		group.setGroupName("1");
		Group groupDB = groupServiceImpl.createAndUpdateGroup(group);
		assertNotNull(groupDB);
		assertEquals(group.getGroupName(), groupDB.getGroupName());
		groupServiceImpl.deleteGroup(group.getGroupName());
	}

	@Test
	public void testGetOne() {
		Group group = new Group();
		group.setCourse(1);
		group.setGroupName("1");
		Group groupGag = groupServiceImpl.createAndUpdateGroup(group);
		Group groupDB = groupServiceImpl.getGroup(group.getGroupName());
		assertNotNull(groupDB);
		assertEquals(group.getGroupName(), groupDB.getGroupName());
		groupServiceImpl.deleteGroup(group.getGroupName());
	}

	@Test
	public void testFindAllByCourse() {
		Group group = new Group();
		group.setCourse(923894);
		group.setGroupName("1");
		groupServiceImpl.createAndUpdateGroup(group);
		List<Group> groupsDB = groupServiceImpl.findAllGroupsByCourse(923894);
		Integer size = groupsDB.size();
		log.info(size.toString());
		Group groupFromArray = groupsDB.get(0);
		assertEquals(group.getCourse(),groupFromArray.getCourse());
		groupServiceImpl.deleteGroup(group.getGroupName());
	}

	@Test
	public void testDelete() {
		Group group = new Group();
		group.setCourse(1);
		group.setGroupName("1");
		groupServiceImpl.createAndUpdateGroup(group);
		groupServiceImpl.deleteGroup(group.getGroupName());
		Group groupDB = groupServiceImpl.getGroup(group.getGroupName());
		assertNull(groupDB);
	}

}
