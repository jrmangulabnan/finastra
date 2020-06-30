package org.finastra.exam.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ConfigurationProperties("oracle")
public class RepositoryConfig {

	@Bean
	DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser("jrmangulabnan");
		dataSource.setPassword("password");
		dataSource.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}

}