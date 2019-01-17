package com.example.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.component.ComponentDAO;

@SpringBootApplication
@ComponentScan("com.example.demo.component")
public class ComponentScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(ComponentScopeApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ComponentScopeApplication.class, args);
		ComponentDAO p1 = context.getBean(ComponentDAO.class);
		LOGGER.info("{}", p1);
		LOGGER.info("{}", p1.getConnection());
		ComponentDAO p2 = context.getBean(ComponentDAO.class);
		LOGGER.info("{}", p2);
		LOGGER.info("{}", p2.getConnection());

	}
}
