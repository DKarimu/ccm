package com.dari.ccm.service;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigServiceTest {

    @Test
    public void testGetApplicationVersion() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        String applicationVersion = configService.getApplicationVersion();
        assertNotNull(applicationVersion);
        assertEquals("0.0.0", applicationVersion);
    }

    @Test
    public void testGetUserEmail() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        String userEmail = configService.getUserEmail();
        assertNotNull(userEmail);
        assertEquals("hoster@gmail.com", userEmail);
    }

    @Test
    public void testGetUserEmailPassword() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        String userEmailPassword = configService.getUserEmailPassword();
        assertNotNull(userEmailPassword);
        assertEquals("blabla-to-blabla", userEmailPassword);
    }

    @Test
    public void testGetTargetEmailAddresses() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        List<String> targetEmailAddresses = configService.getTargetEmailAddresses();
        assertNotNull(targetEmailAddresses);
        assertFalse(targetEmailAddresses.isEmpty());
        assertTrue(targetEmailAddresses.contains("target1@example.com"));
        assertTrue(targetEmailAddresses.contains("target2@example.com"));
        assertTrue(targetEmailAddresses.contains("target3@example.com"));
    }

    @Test
    public void testGetTargetEmailTitles() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        List<String> targetEmailTitles = configService.getTargetEmailTitles();
        assertNotNull(targetEmailTitles);
        assertFalse(targetEmailTitles.isEmpty());
        assertTrue(targetEmailTitles.contains("title1"));
        assertTrue(targetEmailTitles.contains("title2"));
        assertTrue(targetEmailTitles.contains("title3"));
    }

    @Test
    public void testGetEmailProperties() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        Map<String, String> emailProperties = configService.getEmailProperties();
        assertNotNull(emailProperties);
        assertFalse(emailProperties.isEmpty());
        assertEquals("imaps", emailProperties.get("protocol"));
        assertEquals("imap.gmail.com", emailProperties.get("host"));
        assertEquals("993", emailProperties.get("port"));
    }

    @Test
    public void testGetReceivingEmailLabelNames() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        List<String> receivingEmailLabelNames = configService.getReceivingEmailLabelNames();
        assertNotNull(receivingEmailLabelNames);
        assertFalse(receivingEmailLabelNames.isEmpty());
        assertTrue(receivingEmailLabelNames.contains("マク"));
    }

    @Test
    public void testGetDatabaseInfo() {
        ConfigService configService = ConfigService.getInstance();
        assertNotNull(configService);

        String databaseUrl = configService.getDatabaseUrl();
        assertNotNull(databaseUrl);
        assertEquals("jdbc:postgresql://localhost:5432/CCM", configService.getDatabaseUrl());
        assertEquals("your-database-host", configService.getDatabaseHost());
        assertEquals(5432, configService.getDatabasePort());
        assertEquals("postgres", configService.getDatabaseUsername());
        assertEquals("ccm1", configService.getDatabasePassword());
    }
}
