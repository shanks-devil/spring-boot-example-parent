package com.github.shanks.spring.boot.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.shanks.spring.boot.domain.user.User;
import com.github.shanks.spring.boot.user.repository.UserRepostory;

@Service
public class UserService {

	@Autowired
	private UserRepostory userRepostory;
	
	public List<User> selectUserList() {
		return userRepostory.selectUserList();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public User create(User userModel) {
		userRepostory.create(userModel);
		return userModel;
	}
	
	public User selectUser(Long userId) {
		return userRepostory.selectUser(userId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(long userId) {
		userRepostory.delete(userId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void update(User userModel) {
		userRepostory.update(userModel);
	}

}
