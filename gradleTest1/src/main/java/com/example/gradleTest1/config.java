package com.example.gradleTest1;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
// 20240207-3
@Configuration
public class config {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://krdrive.ipdisk.co.kr:3306/syb"); //20240207-7
		dataSource.setUsername("syb"); //20240207-7
		dataSource.setPassword("123456");
		return dataSource;
	}
	@Bean
		public JdbcTemplate jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
	}
}
