package com.dari.ccm;

import com.dari.ccm.entitys.ApplicationConfig;
import com.dari.ccm.entitys.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailFileParser {
    private static final Logger logger = LogManager.getLogger();

    public static Email[] fetchEmails(ApplicationConfig config) {
        try {
            String username = config.getEmailSettings().getUserEmail();
            String password = config.getEmailSettings().getUserEmailPassword();

            Properties properties = new Properties();
            properties.put("mail.store.protocol", config.getEmailSettings().getProperties().get("protocol"));
            properties.put("mail.imaps.host", config.getEmailSettings().getProperties().get("host"));
            properties.put("mail.imaps.port", config.getEmailSettings().getProperties().get("port"));

            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore(config.getEmailSettings().getProperties().get("protocol"));
            store.connect(config.getEmailSettings().getProperties().get("host"), username, password);

            List<Email> emailList = new ArrayList<>();

            List<String> labelNames = config.getOptions().getReceivingEmailLabelName();
            for (String label : labelNames) {
                Folder folder = store.getFolder(label);
                folder.open(Folder.READ_WRITE);

                Flags seen = new Flags(Flags.Flag.SEEN);
                FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
                Message[] messages = folder.search(unseenFlagTerm);

                logger.debug("OK: The email " + username + " is valid and has " + messages.length + " emails in label " + label);

                for (Message message : messages) {
                    String subject = message.getSubject();
                    String[] from = toStringArray(message.getFrom());
                    String[] to = toStringArray(message.getRecipients(Message.RecipientType.TO));
                    Date sentDate = message.getSentDate();
                    String content = message.getContent().toString();

                    Email email = new Email(subject, from, to, sentDate, content);
                    emailList.add(email);

                    logger.debug("fetching email: Date[" + sentDate + "], " +
                            " From[" + from[0] + "], " +
                            " Subject[" + subject + "]");
                }

                folder.close(false);
            }

            store.close();

            return emailList.toArray(new Email[0]);
        } catch (Exception e) {
            logger.error(e.getMessage());
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
