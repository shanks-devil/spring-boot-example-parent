package com.github.shanks.spring.boot.web;

import java.util.Arrays;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.shanks.spring.boot.web.filter.ExampleFilter;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public FilterRegistrationBean filter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new ExampleFilter());
		registration.setUrlPatterns(Arrays.asList(new String[]{"/*"}));
		return registration;
	}
	
}
