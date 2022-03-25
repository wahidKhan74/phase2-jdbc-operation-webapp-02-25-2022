package com.simplilearn.webapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	// data source config
	private String url ="jdbc:mysql://localhost:3306/ecomwebapp";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String username="root";
	private String password="root";
	
	private Connection connection;
	
	//create connection
	public DbConnection() {
		try {
			// 1. register driver
			Class.forName(driver);
			// 2. create connection
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} catch (SQLException e) {
			// e.printStackTrace();
		}		
	}
	
	// get connection
	public Connection getConnection() {
		return connection;
	}
	
	//close connection
	public void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
