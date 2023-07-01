import com.dari.ccm.EmailFileParser;
import com.dari.ccm.entitys.Email;
import com.dari.ccm.utils.ConfigLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.dari.ccm.utils.DataExtractor.extractAmountFromString;

public class Test {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        ConfigLoader cfg = new ConfigLoader();
        EmailFileParser ea = new EmailFileParser(cfg.getApplicationConfig());
//        String pattern = "\\d{1,3}(,\\d{3})* 円";
        String pattern = "¥(\\d+)";


        // Define your CSS selector
        String cssSelector = "#m_8374924799506649276m_6701113326483431463m_1020237398342373831body > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > font"; // Modify this according to your HTML structure

        Email[] emails = ea.fetchEmails();
        for (Email email : emails) {
            String input = email.getPlainTextContent();
            int amount = extractAmountFromString(input, pattern);
            try {
//                logger.debug(email.getContent());
                logger.debug(email.getSentDate());
                logger.debug("Extracted amount: " + amount);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
