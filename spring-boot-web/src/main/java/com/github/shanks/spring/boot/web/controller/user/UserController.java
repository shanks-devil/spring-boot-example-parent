package com.github.shanks.spring.boot.web.controller.user;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.github.shanks.spring.boot.domain.enumeration.UserStatus;
import com.github.shanks.spring.boot.domain.user.User;

@Controller
@RequestMapping("/springmvc")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/user_view")
	ModelAndView userView() { 
		ModelAndView modelandView = new ModelAndView("/user/user_list");
		return modelandView;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	Object users() {
		return restTemplate.getForObject("http://localhost:8090/api/user", List.class);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	Object createUser() {
		User user = new User();
		user.setUserName("test");
		user.setUserEmail("test@git.com");
		user.setUserPhone("213");
		user.setCreateTime(DateTime.now());
		user.setCreateUserId(3l);
		user.setModifyTime(DateTime.now());
		user.setModifyUserId(3l);
		user.setStatus(UserStatus.VALID);
		return restTemplate.postForEntity("http://localhost:8090/api/user", user ,Object.class);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	Object user(@PathVariable Long userId) {
		Object o = restTemplate.getForObject("http://localhost:8090/api/user/"+userId, Object.class);
		return o;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	void deleteUser(@PathVariable Long userId) {
		restTemplate.delete("http://localhost:8090/api/user/"+userId);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	void updateUser() {
		Map<String, Object> map = null;
		restTemplate.put("http://localhost:8090/api/user", map);
	}
	
	
}
