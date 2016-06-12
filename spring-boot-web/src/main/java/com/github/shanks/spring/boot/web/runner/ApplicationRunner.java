package com.github.shanks.spring.boot.web.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(value = 1)
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

	@Value("${phase}")
	private String phase;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("applicationRunner... {}", phase);
	}

}
