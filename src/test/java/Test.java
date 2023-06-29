import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            // Path to the HTML file
            String filePath = "C:\\Projects\\ccm\\emailhtmls\\file.html";

            // Load the HTML file
            File htmlFile = new File(filePath);
            Document doc = Jsoup.parse(htmlFile, "UTF-8");

            // Define your CSS selector
            String cssSelector = "#templateBody > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(2)"; // Modify this according to your HTML structure

            // Select elements based on the CSS selector
            Elements elements = doc.select(cssSelector);

            // Iterate over the selected elements
            for (Element element : elements) {
                String extractedData = element.text();
                System.out.println("Extracted data: " + extractedData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
