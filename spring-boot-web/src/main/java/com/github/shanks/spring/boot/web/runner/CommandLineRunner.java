package com.github.shanks.spring.boot.web.runner;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(value = 0)
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("CommandLineRunner");
	}

}
