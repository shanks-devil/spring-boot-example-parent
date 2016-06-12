package com.github.shanks.spring.boot.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.shanks.spring.boot.domain.user.User;
import com.github.shanks.spring.boot.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	List<User> users() {
		return userService.selectUserList();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	User create(@RequestBody User userModel) {
		return userService.create(userModel);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	User user(@PathVariable Long userId) {
		return userService.selectUser(userId);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	Object delete(@PathVariable Long userId) {
		userService.delete(userId);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	Object update(@RequestBody User userModel) {
		userService.update(userModel);
		return HttpStatus.OK;
	}
}
