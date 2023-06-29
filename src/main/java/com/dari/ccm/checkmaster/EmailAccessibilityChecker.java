package com.dari.ccm.checkmaster;

import com.dari.ccm.entitys.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.io.IOException;

public class EmailAccessibilityChecker {
    private static final Logger logger = LogManager.getLogger();

    public static boolean isEmailAccessible(String email) {
        String url = "https://mail.google.com/mail/gxlu?email=" + email;
        try {
            URL emailUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) emailUrl.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            connection.disconnect();

            logger.debug("OK: The email " + email + " is valid");
            logger.debug("Response Code: " + responseCode);

            return responseCode == HttpURLConnection.HTTP_NO_CONTENT;
        } catch (IOException e) {
            logger.error("Error checking email accessibility: " + e.getMessage());
            return false;
        }
    }

    public static boolean isEmailValid(String email) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "your_smtp_host"); // Replace with your SMTP server host
        properties.put("mail.smtp.port", "your_smtp_port"); // Replace with your SMTP server port

        Session session = Session.getDefaultInstance(properties, null);
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.close();
            return true;
        } catch (AddressException e) {
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Email[] fetchEmails(String username, String password, String label) {
        try {
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imaps.host", "imap.gmail.com");
            properties.put("mail.imaps.port", "993");

            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", username, password);

            Folder folder = store.getFolder(label);
            folder.open(Folder.READ_ONLY);

            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            Message[] messages = folder.search(unseenFlagTerm);

            Email[] emails = new Email[messages.length];
            logger.debug("OK: The email " + username + " is valid get " + messages.length + " Email");

            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                String subject = message.getSubject();
                String[] from = toStringArray(message.getFrom());
                String[] to = toStringArray(message.getRecipients(Message.RecipientType.TO));
                Date sentDate = message.getSentDate();
                String content = message.getContent().toString();

                Email email = new Email(subject, from, to, sentDate, content);
                emails[i] = email;
                logger.debug("from [" + from + "]" + from);
            }

            folder.close(false);
            store.close();

            return emails;
        } catch (Exception e) {
            e.printStackTrace();
            return new Email[0]; // Return an empty array in case of an error
        }
    }

    private static String[] toStringArray(Address[] addresses) {
        if (addresses == null) {
            return new String[0];
        }

        String[] stringAddresses = new String[addresses.length];
        for (int i = 0; i < addresses.length; i++) {
            stringAddresses[i] = addresses[i].toString();
        }
        return stringAddresses;
    }
}
