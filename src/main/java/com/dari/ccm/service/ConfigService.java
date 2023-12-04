package com.dari.ccm.service;

import com.dari.ccm.entitys.ApplicationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConfigService {
    private static final Logger logger = LogManager.getLogger();
    private static final String CONFIG_FILE_NAME = "ccm_config.yaml";
    private static final ConfigService instance = new ConfigService(CONFIG_FILE_NAME);
    private final ApplicationConfig config;

    private ConfigService(String filePath) {
        this.config = load(ApplicationConfig.class, filePath);
        logger.debug("Successfully loaded ApplicationConfig from file: " + filePath);
    }

    public static ConfigService getInstance() {
        return instance;
    }

    private <T> T load(Class<T> valueType, String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            return mapper.readValue(new File(filePath), valueType);
        } catch (IOException e) {
            logger.error("Error loading ApplicationConfig from file: " + filePath, e);
            logger.debug("Returning null ApplicationConfig");
            return null;
        }
    }

    public String getApplicationVersion() {
        return config.getApplication().getApplicationVersion();
    }

    public String getUserEmail() {
        return config.getEmailSettings().getUserEmail();
    }

    public String getUserEmailPassword() {
        return config.getEmailSettings().getUserEmailPassword();
    }

    public List<String> getTargetEmailAddresses() {
        return config.getEmailSettings().getTargetEmailAddresses();
    }

    public List<String> getTargetEmailTitles() {
        return config.getEmailSettings().getTargetEmailTitle();
    }

    public Map<String, String> getEmailProperties() {
        return config.getEmailSettings().getProperties();
    }

    public List<String> getReceivingEmailLabelNames() {
        return config.getOptions().getReceivingEmailLabelName();
    }

    public String getDatabaseUrl() {
        return config.getDatabase().getUrl();
    }

    public String getDatabaseHost() {
        return config.getDatabase().getHost();
    }

    public int getDatabasePort() {
        return config.getDatabase().getPort();
    }

    public String getDatabaseUsername() {
        return config.getDatabase().getUsername();
    }

    public String getDatabasePassword() {
        return config.getDatabase().getPassword();
    }
}
