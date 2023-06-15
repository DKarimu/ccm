package com.dari.ccm.checkmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseChecker {
    public static boolean isOracleDBRunning(String url, String username, String password) {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            // Check if the connection is valid
            boolean isRunning = connection.isValid(5000); // Timeout in milliseconds
            // Close the connection
            connection.close();
            return isRunning;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
