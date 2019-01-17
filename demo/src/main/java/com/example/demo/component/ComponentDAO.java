package com.example.demo.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ComponentDAO {
	@Autowired
	private ComponentJDBCConnection connection;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ComponentJDBCConnection getConnection() {
		return connection;
	}

	public void setConnection(ComponentJDBCConnection connection) {
		this.connection = connection;
	}

	@PostConstruct
	public void postConstruct() {
		logger.info("nagesh");
	}

}
