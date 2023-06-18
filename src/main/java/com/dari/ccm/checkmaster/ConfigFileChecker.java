package com.dari.ccm.checkmaster;

import com.dari.ccm.entitys.Configurations;
import com.dari.ccm.utils.ConfigLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigFileChecker {
    private static final Logger logger = LogManager.getLogger(ConfigFileChecker.class);
    private static final String CONFIG_FILE_NAME = "ccm_config.yaml";

    public static boolean configFileChecker() {
        try {
            ConfigLoader loader = new ConfigLoader(CONFIG_FILE_NAME);
            loader.load(Configurations.class);
            logger.debug("configFileChecker() ->OK");
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("configFileChecker() ->NG");
        return false;
    }
}