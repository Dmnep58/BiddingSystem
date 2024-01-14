package com.Backend.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection connection;

    private static final String URL = "dbc:mysql://localhost:3306/bidding_system";
    private  static final String USER = "root";
    private static final String PASSWORD = "1424";

    public static Connection getDBConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
