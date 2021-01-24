package com.cherradi.ensah.test;

import java.sql.Connection;

import com.cherradi.ensah.utils.JDBCUtils;

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
