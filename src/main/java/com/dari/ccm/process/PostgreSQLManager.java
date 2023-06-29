package com.dari.ccm.process;

import com.dari.ccm.checkmaster.ConfigFileChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class PostgreSQLManager {
    private static final String DATA_DIRECTORY = "C:\\Program Files\\PostgreSQL\\15\\data";
    private static final Logger logger = LogManager.getLogger();

    public static void startPostgreSQL() {
        try {
            String[] command = {
                    "C:\\Program Files\\PostgreSQL\\15\\bin\\pg_ctl.exe", // PostgreSQL control command
                    "start",  // Start the PostgreSQL server
                    "-D",     // Specify the data directory
                    DATA_DIRECTORY // Data directory path
            };
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                logger.debug("->OK: PostgreSQL started successfully.");
            } else {
                logger.error("->NG: Failed to start PostgreSQL. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
