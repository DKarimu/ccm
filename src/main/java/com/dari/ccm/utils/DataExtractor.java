package com.dari.ccm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtractor {
    private static final Logger logger = LogManager.getLogger();

    public String extractDataFromHtmlString(String htmlString, String cssSelector) {
        Document doc = Jsoup.parse(htmlString);
        Elements elements = doc.select(cssSelector);
        StringBuilder extractedDataBuilder = new StringBuilder();
        for (Element element : elements) {
            String extractedData = element.text();
            extractedDataBuilder.append(extractedData);
        }
        return extractedDataBuilder.toString();
    }

    public static int extractAmountFromString(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            String matchedData = matcher.group();
            String amountStr = matchedData.replaceAll("[^\\d]", "");
            return Integer.parseInt(amountStr);
        } else {
            return 0; // or throw an exception or handle the absence of a match as needed
        }
    }
}
