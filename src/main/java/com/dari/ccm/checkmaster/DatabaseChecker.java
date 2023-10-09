package com.dari.ccm.checkmaster;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseChecker {
    private static final Logger logger = LogManager.getLogger();
    public static boolean isPostgreSQLRunning(String url, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
            logger.debug("OK: The database is running.");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.warn("OK: The database is running.");
        return false;
    }
}
