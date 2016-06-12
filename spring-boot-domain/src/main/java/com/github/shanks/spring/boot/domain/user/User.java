package com.github.shanks.spring.boot.domain.user;

import java.io.Serializable;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.shanks.spring.boot.common.json.DateTimeDeserialize;
import com.github.shanks.spring.boot.common.json.DateTimeSerialize;
import com.github.shanks.spring.boot.domain.enumeration.UserStatus;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	
	private String userName;
	
	private String userEmail;
	
	private String userPhone;
	
	@JsonDeserialize(using = DateTimeDeserialize.class)
	@JsonSerialize(using = DateTimeSerialize.class)
	private DateTime createTime;
	
	private Long createUserId;
	
	@JsonDeserialize(using = DateTimeDeserialize.class)
	@JsonSerialize(using = DateTimeSerialize.class)
	private DateTime modifyTime;
	
	private Long modifyUserId;
	
	private UserStatus status;
	
}
