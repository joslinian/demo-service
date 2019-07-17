package com.startech.demo;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Configuration
@Component
@PropertySource({ "classpath:application.properties" })
public class DatabaseConfig {

    @Bean
    public BasicDataSource dataSource(@Value("${spring.datasource.driver-class-name}") final String driverClass,
                                      @Value("${spring.datasource.url}") final String jdbcUrl,
                                      @Value("${spring.datasource.username}") final String username,
                                      @Value("${spring.datasource.password}") final String password) throws URISyntaxException {
//        String dbUrl = System.getenv("JDBC_DATABASE_URL");
//        String username = System.getenv("JDBC_DATABASE_USERNAME");
//        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUrl(jdbcUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setDriverClassName(driverClass);

        return basicDataSource;
    }
}
