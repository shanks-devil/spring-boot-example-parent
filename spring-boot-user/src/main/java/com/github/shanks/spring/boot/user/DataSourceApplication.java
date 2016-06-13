package com.github.shanks.spring.boot.user;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceApplication {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	/**
	 * use HikariDataSource
	 * @return
	 */
	DataSource dataSource() {
		return new HikariDataSource();
	}
	
}
