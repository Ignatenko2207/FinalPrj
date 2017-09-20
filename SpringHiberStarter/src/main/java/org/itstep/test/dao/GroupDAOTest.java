package org.itstep.test.dao;


import org.itstep.dao.GroupDAO;
import org.itstep.test.App;
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
	}

}
