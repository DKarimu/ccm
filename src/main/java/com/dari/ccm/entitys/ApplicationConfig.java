package com.dari.ccm.entitys;

import com.dari.ccm.utils.ConfigLoader;

import java.util.List;
import java.util.Map;

public class ApplicationConfig {
    private Application application;
    private EmailSettings emailSettings;
    private Options options;
    private DatabaseConfig database;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public EmailSettings getEmailSettings() {
        return emailSettings;
    }

    public void setEmailSettings(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public DatabaseConfig getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfig database) {
        this.database = database;
    }

    public static class Application {
        private String applicationVersion;

        public String getApplicationVersion() {
            return applicationVersion;
        }

        public void setApplicationVersion(String applicationVersion) {
            this.applicationVersion = applicationVersion;
        }
    }

    public static class EmailSettings {
        private String userEmail;
        private String userEmailPassword;
        private List<String> targetEmailAddresses;
        private List<String> targetEmailTitle;
        private Map<String, String> properties;

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserEmailPassword() {
            return userEmailPassword;
        }

        public void setUserEmailPassword(String userEmailPassword) {
            this.userEmailPassword = userEmailPassword;
        }

        public List<String> getTargetEmailAddresses() {
            return targetEmailAddresses;
        }

        public void setTargetEmailAddresses(List<String> targetEmailAddresses) {
            this.targetEmailAddresses = targetEmailAddresses;
        }

        public List<String> getTargetEmailTitle() {
            return targetEmailTitle;
        }

        public void setTargetEmailTitle(List<String> targetEmailTitle) {
            this.targetEmailTitle = targetEmailTitle;
        }

        public Map<String, String> getProperties() {
            return properties;
        }

        public void setProperties(Map<String, String> properties) {
            this.properties = properties;
        }
    }

    public static class Options {
        private List<String> receivingEmailLabelName;

        public List<String> getReceivingEmailLabelName() {
            return receivingEmailLabelName;
        }

        public void setReceivingEmailLabelName(List<String> receivingEmailLabelName) {
            this.receivingEmailLabelName = receivingEmailLabelName;
        }
    }

    public static class DatabaseConfig {
        private String url;
        private String host;
        private int port;
        private String username;
        private String password;
        private String database;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }
    }
}
