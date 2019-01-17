package com.example.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.scope.PersonDAO;

@SpringBootApplication
public class ScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(ScopeApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ScopeApplication.class, args);
		PersonDAO p1 = context.getBean(PersonDAO.class);
		LOGGER.info("{}", p1);
		LOGGER.info("{}", p1.getConnection());
		PersonDAO p2 = context.getBean(PersonDAO.class);
		LOGGER.info("{}", p2);
		LOGGER.info("{}", p2.getConnection());

	}
}
