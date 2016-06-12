package com.github.shanks.spring.boot.web.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Listener implements ApplicationListener<ApplicationReadyEvent>{

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("load fininsh...");
	}

}
