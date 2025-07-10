package com.freelance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/freelancedb";
    private static final String USER = "postgres"; // change if needed
    private static final String PASSWORD = "@Kris#008"; // change this

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
