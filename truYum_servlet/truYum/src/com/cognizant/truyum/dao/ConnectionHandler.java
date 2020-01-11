package com.cognizant.truyum.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionHandler {

	public static Connection getConnection() {
		
		BufferedInputStream bufferedInputStream = (BufferedInputStream)ConnectionHandler.class.getClassLoader().getResourceAsStream("connection.properties");
		Properties prop=new Properties();
		Connection connection=null;
		try {
			prop.load(bufferedInputStream);
		} catch (IOException e) {
			System.out.println("Unable to load connection.Properties files");
		}
		String driver=(String)prop.get("driver");
		//System.out.println("Driver Name->"+driver);
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the my sql driver");
		}
		String user=(String)prop.get("user");
		String password=(String)prop.get("password");
		String url=(String)prop.get("connection-url");
		
		//System.out.println("connection Details->"+user+"--"+password+"--"+url);
		try {
			//A connection (session ) with a specific database
			//Driver Manager class will attempt to load the driver class
			connection=DriverManager.getConnection(url,user,password);
			//System.out.println(connection);
		} catch (SQLException e) {
			System.out.println("Unable to connect to database ");
		}

		return connection;

	}
}
