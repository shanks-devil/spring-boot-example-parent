package com.github.shanks.spring.boot.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.shanks.spring.boot.domain.user.User;
import com.github.shanks.spring.boot.user.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles(value = "jtest")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void selectUser() {
		System.out.println(userService.selectUserList());
	}
	
	@Test
	public void create() {
		User user = new User();
		user.setUserName("test-@Transactional001");
		userService.create(user);
	}
	
}
