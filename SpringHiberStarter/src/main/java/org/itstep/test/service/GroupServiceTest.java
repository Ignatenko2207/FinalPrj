package org.itstep.test.service;

import org.itstep.dao.pojo.Group;
import org.itstep.test.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GroupServiceTest {

	@Test
	public void testCreateAndUpdate() {
		Group group = new Group();
		
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
