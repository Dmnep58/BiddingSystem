package com.biddingsystem.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	static Connection connection;
	
	
    private static final String URL = "jdbc:mysql://localhost:3306/online_bidding_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1424";

    public static Connection getConnection() throws SQLException {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}