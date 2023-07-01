package com.dari.ccm.entitys;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emailId;
    private String subject;
    private String[] from;
    private String[] to;
    private Date sentDate;
    private String content;

    public Email(String subject, String[] from, String[] to, Date sentDate, String content) {
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.sentDate = sentDate;
        this.content = content;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getFrom() {
        return from;
    }

    public void setFrom(String[] from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", subject='" + subject + '\'' +
                ", from=" + Arrays.toString(from) +
                ", to=" + Arrays.toString(to) +
                ", sentDate=" + sentDate +
                ", content='" + content + '\'' +
                '}';
    }

    public String getPlainTextContent() {
        String plainText = content;
        plainText = plainText.replaceAll("<[^>]+>", "");
        plainText = plainText.replaceAll("\\u00A0", "");
        plainText = plainText.replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
        return plainText.trim();
    }
}
