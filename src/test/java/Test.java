import com.dari.ccm.checkmaster.ConfigFileChecker;
import com.dari.ccm.checkmaster.DatabaseChecker;
import com.dari.ccm.checkmaster.EmailAccessibilityChecker;
import com.dari.ccm.entitys.Email;
import com.dari.ccm.process.PostgreSQLManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import java.util.Arrays;

public class Test {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        EmailAccessibilityChecker ea = new EmailAccessibilityChecker();
        Email[] emails = ea.fetchEmails("d.erikrimo@gmail.com", "dezjuhssjodpzyke", "INBOX");
        for (Email email : emails) {
            try {
                System.out.println("Subject: " + email.getSubject());
                System.out.println("From: " + email.getFrom());
                System.out.println("To: " + email.getTo());
                System.out.println("Date: " + email.getSentDate());
                System.out.println("Content: " + email.getContent());
                System.out.println("-------------------------------------");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}

//import java.util.Properties;
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Store;
//
//public class Test {
//    public static void main(String[] args) {
//        try {
//            // Gmail account credentials
//            String username = "d.erikrimo@gmail.com";
//            String password = "dezjuhssjodpzyke";
//
//            // IMAP server properties
//            Properties properties = new Properties();
//            properties.put("mail.store.protocol", "imaps");
//            properties.put("mail.imaps.host", "imap.gmail.com");
//            properties.put("mail.imaps.port", "993");
//
//            // Connect to the Gmail IMAP server
//            Session session = Session.getDefaultInstance(properties);
//            Store store = session.getStore("imaps");
//            store.connect("imap.gmail.com", username, password);
//
//            // Open the INBOX folder
//            Folder inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_ONLY);
//
//            // Fetch and display the last 10 emails
//            int messageCount = inbox.getMessageCount();
//            int startIndex = Math.max(1, messageCount - 10); // Retrieve the last 10 emails
//            Message[] messages = inbox.getMessages(startIndex, messageCount);
//
//            for (Message message : messages) {
//                System.out.println("Subject: " + message.getSubject());
//                System.out.println("From: " + message.getFrom()[0]);
//                System.out.println("--------------");
//            }
//
//            // Close the connections
//            inbox.close(false);
//            store.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
