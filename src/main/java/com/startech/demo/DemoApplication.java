package com.startech.demo;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			System.out.println("Inspect beans provided by Spring Boot: ");

			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName: beanNames) {
				System.out.println(beanName);
			}
		};
	}

	@Bean
	public JdbcTemplate jdbcTemplate(@Autowired BasicDataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public BasicDataSource dataSource()  throws URISyntaxException {
//		URI dbUri = new URI(System.getenv("DATABASE_URL"));
//
//		String username = dbUri.getUserInfo().split(":")[0];
//		String password = dbUri.getUserInfo().split(":")[1];
//		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

		String username = "lschkhdltstwnr";
		String password = "390b67b5e82e6ccd19652b8fad6474ad9690121c6218181a1896ac6772b96d5f";
		String dbUrl = "jdbc:postgres://lschkhdltstwnr:390b67b5e82e6ccd19652b8fad6474ad9690121c6218181a1896ac6772b96d5f@ec2-23-21-160-38.compute-1.amazonaws.com:5432/d7vftmfs9pugjs\n?sslmode=require";

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);

		return basicDataSource;
	}
}
