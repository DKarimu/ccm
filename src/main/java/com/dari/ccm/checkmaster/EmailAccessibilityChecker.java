package com.dari.ccm.checkmaster;

import java.net.HttpURLConnection;
import java.net.URL;

public class EmailAccessibilityChecker {
    public static boolean isEmailAccessible(String email) {
        String url = "https://mail.google.com/mail/gxlu?email=" + email;
        try {
            URL emailUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) emailUrl.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
