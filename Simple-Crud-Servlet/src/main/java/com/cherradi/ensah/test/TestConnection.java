package com.cherradi.ensah.test;

import java.sql.Connection;

import com.cherradi.ensah.utils.JDBCUtils;

/**
 * The first thing we need to verify it, is to test connection with db. Before we start developement of dao layer
 * we make sure the connection with db establish successufelly
 * 
 * @author = CHERRADI Mohamed
 * 
 * @email = med1995cherradi@gmail.com
 * 
 * 
 */

public class TestConnection {
	
	public static void main(String[] args) {
		
		Connection conn = JDBCUtils.getConnection();
		if (conn == null) {
			System.out.println("Ooops, connection failed !!!");
		}else {
			System.out.println("Congratulations, your are connected successufelly !!!");
		}
		
	}

}
