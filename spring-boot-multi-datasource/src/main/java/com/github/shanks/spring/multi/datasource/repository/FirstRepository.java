package com.github.shanks.spring.multi.datasource.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.shanks.spring.boot.domain.user.User;
import com.github.shanks.spring.multi.datasource.MultiDatabaseConfiguration.First;

@Mapper
@First
public interface FirstRepository {

	List<User> selectUserList();
	
	void create(User user);
	
}
