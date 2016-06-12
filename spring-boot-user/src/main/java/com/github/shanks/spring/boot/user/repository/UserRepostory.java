package com.github.shanks.spring.boot.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.shanks.spring.boot.domain.user.User;

@Mapper
public interface UserRepostory {

	List<User> selectUserList();
	
	void create(User userModel);
	
	User selectUser(Long userId);

	void delete(long userId);
	
	void update(User userModel);
}
