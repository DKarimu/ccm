package com.dari.ccm.checkmaster;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class ConfigFileChecker {
    public static boolean configFileChecker(String filePath) {
        try {
            // Load the YAML file
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Map<String, Object> configFile = yaml.load(fileInputStream);
            // Check if the required items exist
            if (configFile.containsKey("application") &&
                    configFile.containsKey("emails settings") &&
                    configFile.containsKey("Options") &&
                    configFile.containsKey("database")) {
                Map<String, Object> application = (Map<String, Object>) configFile.get("application");
                Map<String, Object> emailSettings = (Map<String, Object>) configFile.get("emails settings");
                Map<String, Object> options = (Map<String, Object>) configFile.get("Options");
                Map<String, Object> database = (Map<String, Object>) configFile.get("database");
                if (application.containsKey("application version") &&
                        application.containsKey("application loges file full-path") &&
                        emailSettings.containsKey("users email") &&
                        emailSettings.containsKey("users email password") &&
                        emailSettings.containsKey("target email addresses") &&
                        options.containsKey("receiving email label name") &&
                        database.containsKey("host") &&
                        database.containsKey("port") &&
                        database.containsKey("username") &&
                        database.containsKey("password") &&
                        database.containsKey("database")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
