package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/risk_monitoring";

    private static final String USER =
            "postgres";

    public static Connection getConnection() throws SQLException {

        String password = "Chrismariya@1412";

        return DriverManager.getConnection(URL, USER, password);
    }
}