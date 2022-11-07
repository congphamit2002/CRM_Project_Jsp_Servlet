package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private final static String url = "jdbc:mysql://127.0.0.1:3306/servlet_crm";
	private final static String username = "root";
	private final static String password = "admin";
	
	public static Connection getConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
		return null;
	}
}
