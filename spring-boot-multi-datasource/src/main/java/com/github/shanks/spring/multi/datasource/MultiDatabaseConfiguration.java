package com.github.shanks.spring.multi.datasource;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.shanks.spring.multi.datasource.MultiDatabaseConfiguration.First;
import com.github.shanks.spring.multi.datasource.MultiDatabaseConfiguration.Second;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class MultiDatabaseConfiguration {

	public @interface First {
	}

	public @interface Second {
	}

	@Bean
	@ConfigurationProperties
	MybatisProperties mybatisProperties() {
		return new MybatisProperties();
	}
}

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan(annotationClass = First.class, sqlSessionFactoryRef = "firstSqlSessionFactory", basePackages = {
		"com.github.shanks.spring.multi.datasource.repository" })
class FirstDataSourceConfiguration {

	@Autowired
	private MybatisProperties mybatisProperties;
	
	@Bean
	DataSourceTransactionManager fristDataSourceTransactionManager() {
		return new DataSourceTransactionManager(firstDataSource());
	}
	
	@Bean
	SqlSessionFactoryBean firstSqlSessionFactory() {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(firstDataSource());
		bean.setMapperLocations(mybatisProperties.resolveMapperLocations());
		bean.setTypeHandlersPackage(mybatisProperties.getTypeHandlersPackage());
		bean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
		return bean;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	// user HikariDatasource and HikairPool
	public DataSource firstDataSource() {
		return new HikariDataSource();
	}
}

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan(annotationClass = Second.class, sqlSessionFactoryRef = "secondSqlSessionFactory", basePackages = {
		"com.github.shanks.spring.multi.datasource.repository" })
class SecondDataSourceConfiguration {
	
	@Autowired
	private MybatisProperties mybatisProperties;
	
	@Bean
	DataSourceTransactionManager secondDataSourceTransactionManager() {
		return new DataSourceTransactionManager(secondDataSource());
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.second.datasource")
	// user TomcatDataSource and TomcatPool
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean
	SqlSessionFactoryBean secondSqlSessionFactory() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(secondDataSource());
		bean.setMapperLocations(mybatisProperties.resolveMapperLocations());
		bean.setTypeHandlersPackage(mybatisProperties.getTypeHandlersPackage());
		bean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
		return bean;
	}


}