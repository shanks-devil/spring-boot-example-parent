package com.github.shanks.spring.multi.datasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.shanks.spring.boot.domain.user.User;
import com.github.shanks.spring.multi.datasource.repository.FirstRepository;
import com.github.shanks.spring.multi.datasource.repository.SecondRepository;

@Service
public class MultiDataSourceService {

	@Autowired
	private FirstRepository firstRepository;
	
	@Autowired
	private SecondRepository secondRepository;
	
	public List<User> selectUserFromFirst() {
		return firstRepository.selectUserList();
	}
	
	public List<User> selectUserFromSecond() {
		return secondRepository.selectUserList();
	}
	
	@Transactional(rollbackFor = Exception.class,  value = "fristDataSourceTransactionManager")
	public void createUserFromFirst(int e) {
		User user = new User();
		user.setUserName("@Transactional888");
		firstRepository.create(user);
		if (e == 1) {
			throw new RuntimeException("@Transactional888");
		}
	}
	
	
}
