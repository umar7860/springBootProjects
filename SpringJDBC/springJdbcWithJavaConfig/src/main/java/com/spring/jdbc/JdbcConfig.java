package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImplemention;

@Configuration
public class JdbcConfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}

	@Bean("jdbcTempelate")
	public JdbcTemplate getTempelate() {
		JdbcTemplate jdbcTempelate = new JdbcTemplate();
		jdbcTempelate.setDataSource(getDataSource());
		return jdbcTempelate;
	}
	
	@Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDaoImplemention studentDao = new StudentDaoImplemention();
		studentDao.setJdbcTempelate(getTempelate());
		return studentDao;
	}
}
