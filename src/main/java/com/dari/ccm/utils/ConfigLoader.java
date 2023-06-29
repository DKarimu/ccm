package com.dari.ccm.utils;

import com.dari.ccm.entitys.ApplicationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class ConfigLoader {
    private static final Logger logger = LogManager.getLogger(ConfigLoader.class);
    private static final String CONFIG_FILE_NAME = "ccm_config.yaml";
    private String filePath;

    public ConfigLoader() {
        this.filePath = CONFIG_FILE_NAME;
    }

    public <T> T load(Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(filePath), valueType);
    }

    public ApplicationConfig getApplicationConfig() {
        try {
            ConfigLoader loader = new ConfigLoader();
            ApplicationConfig config = loader.load(ApplicationConfig.class);
            logger.debug("Successfully loaded ApplicationConfig from file: " + CONFIG_FILE_NAME);
            return config;
        } catch (Exception e) {
            logger.error("Error loading ApplicationConfig from file: " + CONFIG_FILE_NAME, e);
        }
        logger.debug("Returning null ApplicationConfig");
        return null;
    }
}
