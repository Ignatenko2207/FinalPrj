package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.itstep.App;
import org.itstep.dao.pojo.Group;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupDAOTest {

	@Autowired
	private GroupDAO dao;
	
	@Spy
	List<Group> groups= new ArrayList<Group>();
	
	public List<Group> getArray(){	
		groups.add(new Group("12pv5",3));
		groups.add(new Group("15pv5",2));
		groups.add(new Group("14pv5",2));
		return groups;
	}
	
	@Before
	public void init() {
		groups = getArray();
	}
	
	@Test
	public void CreateAndDeleteOperationsTest() {
		 Group group = groups.get(0);
		 Group grInDb = dao.saveAndFlush(group);
		 assertEquals(group.getGroupName(), grInDb.getGroupName());	
	
		 dao.delete(grInDb);
		 assertFalse(dao.exists(group.getGroupName()));
	}

}
