package com.github.shanks.spring.multi.datasource.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.shanks.spring.boot.domain.user.User;
import com.github.shanks.spring.multi.datasource.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles(value = "dev")
public class MultiDataSourceServiceTest {

	@Autowired
	private MultiDataSourceService multiDataSourceService;
	
	@Test
	public void selectUserFromFirst() {
		System.out.println(multiDataSourceService.selectUserFromFirst().get(multiDataSourceService.selectUserFromFirst().size()-1));
	}
	
	@Test
	public void selectUserFromSecond() {
		System.out.println(multiDataSourceService.selectUserFromSecond());
	}
	
	@Test
	public void create() {
		User user = new User();
		user.setUserName("test");
		multiDataSourceService.createUserFromFirst(user);
	}
	
}
