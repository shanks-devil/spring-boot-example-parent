package com.github.shanks.spring.boot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = {"com.github.shanks.spring.boot.web"})
@Slf4j
public class WebControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(getStatus(request));
	}
	
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}

}
