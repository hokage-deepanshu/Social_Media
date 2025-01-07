package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // JDBC URL, username, and password for MySQL database
    private static final String URL = "jdbc:mysql://localhost:3306/SocialMedia";
    private static final String USER = "root";
    private static final String PASSWORD = "Tomar@12345";

    // Static method to establish and return a database connection
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful!");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Please add the JDBC connector to your project.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database. Please check the URL, username, or password.");
            e.printStackTrace();
        }

        return connection;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test the connection
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                System.err.println("Failed to close the connection.");
                e.printStackTrace();
            }
        }
    }
}
