package com.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private Connection con;
	
	public static Connection getConnection() {
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/servletproject", 
	                "root",                                       
	                "Shubham@242#"                                
	            );
			
			
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
