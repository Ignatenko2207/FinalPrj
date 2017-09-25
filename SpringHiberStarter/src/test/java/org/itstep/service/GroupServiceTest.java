package org.itstep.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito. *;

import java.util.ArrayList;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.impl.GroupServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupServiceTest {

	@MockBean
	private GroupDAO groupDAO;
	
	@InjectMocks
	private GroupServiceImpl groupService;
	
	@Spy
	List<Group> groups= new ArrayList<Group>();
	
	@Before
	public  void setUp(){
		MockitoAnnotations.initMocks(this);
		groups = getArray();
	}
	
	public List<Group> getArray(){	
		groups.add(new Group("12pv5",3));
		groups.add(new Group("15pv5",2));
		groups.add(new Group("14pv5",2));
		return groups;
	}

	@Test
	public void testCreateAndUpdate() {
		Group group = new Group("12pvS",4);
		when(groupDAO.saveAndFlush(group)).thenReturn(group);
		assertEquals(groupService.getGroup(group.getGroupName()), group);
	}

	@Test
	public void testGetOne() {
		Group group = groups.get(0);
		when(groupDAO.findOne(group.getGroupName())).thenReturn(group);
		assertEquals(groupService.getGroup(group.getGroupName()), group);

	}

	@Test
	public void testFindAllByCourse() {
	}

	@Test
	public void testDelete() {
	}

}
