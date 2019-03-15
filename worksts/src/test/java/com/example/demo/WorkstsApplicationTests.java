package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Model.StdentModel;
import com.example.demo.dao.StudentDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkstsApplicationTests {
	
	@Autowired
	StudentDao studentDao;

//	@Rollback
	
	@Test
	public void contextLoads() {
		StdentModel stdentModel = new StdentModel();
		
		stdentModel.setName("Test01");
		stdentModel.setEmail("TestEmail");
		
		studentDao.insert(stdentModel);
		
	}

}
