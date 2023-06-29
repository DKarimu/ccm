package com.dari.ccm.checkmaster;

import com.dari.ccm.entitys.ApplicationConfig;
import com.dari.ccm.utils.ConfigLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigFileChecker {
    private static final Logger logger = LogManager.getLogger();
    private static final String CONFIG_FILE_NAME = "ccm_config.yaml";

    public static boolean isConfigFileValid() {
        try {
            ConfigLoader loader = new ConfigLoader();
            ApplicationConfig config = loader.load(ApplicationConfig.class);
            logger.debug("> OK: the config file is valid");
            logApplicationConfig(config); // Log the ApplicationConfig properties
            return true;
        } catch (Exception e) {
            logger.error("> NG: the config file is invalid " + e.getMessage());
        }
        logger.debug("> NG: the config file is invalid");
        return false;
    }

    private static void logApplicationConfig(ApplicationConfig config) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonConfig = objectMapper.writeValueAsString(config);
            logger.debug("> ApplicationConfig: " + jsonConfig);
        } catch (JsonProcessingException e) {
            logger.error("Error converting ApplicationConfig to JSON: " + e.getMessage());
        }
    }
}
