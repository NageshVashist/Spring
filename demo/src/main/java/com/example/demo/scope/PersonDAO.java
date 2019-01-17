package com.example.demo.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class PersonDAO {
	
@Autowired
private JDBCConnection connection;

public JDBCConnection getConnection() {
	return connection;
}

public void setConnection(JDBCConnection connection) {
	this.connection = connection;
}


}
