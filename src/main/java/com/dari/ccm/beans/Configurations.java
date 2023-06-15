package com.dari.ccm.beans;

import java.util.Map;

public class Configurations {
    private Application application;
    private EmailSettings emailSettings;
    private Options options;
    private Database database;

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

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}

class Application {
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

class EmailSettings {
    private String usersEmail;
    private String usersEmailPassword;
    private Map<String, String> targetEmailAddresses;
    private Map<String, String> targetEmailTitle;

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getUsersEmailPassword() {
        return usersEmailPassword;
    }

    public void setUsersEmailPassword(String usersEmailPassword) {
        this.usersEmailPassword = usersEmailPassword;
    }

    public Map<String, String> getTargetEmailAddresses() {
        return targetEmailAddresses;
    }

    public void setTargetEmailAddresses(Map<String, String> targetEmailAddresses) {
        this.targetEmailAddresses = targetEmailAddresses;
    }

    public Map<String, String> getTargetEmailTitle() {
        return targetEmailTitle;
    }

    public void setTargetEmailTitle(Map<String, String> targetEmailTitle) {
        this.targetEmailTitle = targetEmailTitle;
    }
}

class Options {
    private String receivingEmailLabelName;

    public String getReceivingEmailLabelName() {
        return receivingEmailLabelName;
    }

    public void setReceivingEmailLabelName(String receivingEmailLabelName) {
        this.receivingEmailLabelName = receivingEmailLabelName;
    }
}

class Database {
    private String host;
    private String port;
    private String username;
    private String password;
    private String databaseName;

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

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}

