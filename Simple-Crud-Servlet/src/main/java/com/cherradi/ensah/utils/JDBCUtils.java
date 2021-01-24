package com.cherradi.ensah.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * this class implements the singleton design pattern to create a single connection with the database.
 * 
 * @author = CHERRADI Mohamed
 * 
 * @email = med1995cherradi@gmail.com
 * 
 */

public class JDBCUtils {
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_servlet_crud", "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	
}
