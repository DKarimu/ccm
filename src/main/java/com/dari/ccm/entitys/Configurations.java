package com.dari.ccm.entitys;

import java.util.List;

public class Configurations {
    private ApplicationSettings application;
    private EmailSettings emailSettings;
    private Options options;
    private DatabaseSettings database;

    public ApplicationSettings getApplication() {
        return application;
    }

    public void setApplication(ApplicationSettings application) {
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

    public DatabaseSettings getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseSettings database) {
        this.database = database;
    }

    public static class ApplicationSettings {
        private String applicationVersion;
        private String applicationLogFilePath;

        public String getApplicationVersion() {
            return applicationVersion;
        }

        public void setApplicationVersion(String applicationVersion) {
            this.applicationVersion = applicationVersion;
        }

        public String getApplicationLogFilePath() {
            return applicationLogFilePath;
        }

        public void setApplicationLogFilePath(String applicationLogFilePath) {
            this.applicationLogFilePath = applicationLogFilePath;
        }
    }

    public static class EmailSettings {
        private List<String> usersEmail;
        private List<String> usersEmailPassword;
        private List<String> targetEmailAddresses;
        private List<String> targetEmailTitle;

        public List<String> getUsersEmail() {
            return usersEmail;
        }

        public void setUsersEmail(List<String> usersEmail) {
            this.usersEmail = usersEmail;
        }

        public List<String> getUsersEmailPassword() {
            return usersEmailPassword;
        }

        public void setUsersEmailPassword(List<String> usersEmailPassword) {
            this.usersEmailPassword = usersEmailPassword;
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

    public static class DatabaseSettings {
        private String host;
        private String port;
        private String username;
        private String password;
        private String database;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
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
