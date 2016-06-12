package com.github.shanks.spring.boot.web.shutdown;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Shutdown implements ExitCodeGenerator {

	@Override
	public int getExitCode() {
		log.info("Shutdown 200");
		return 200;
	}

}
