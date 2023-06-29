package com.dari.ccm.entitys;

import java.util.Arrays;
import java.util.Date;

public class Email {
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

    public String getSubject() {
        return subject;
    }

    public String[] getFrom() {
        return from;
    }

    public String[] getTo() {
        return to;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "subject='" + subject + '\'' +
                ", from=" + Arrays.toString(from) +
                ", to=" + Arrays.toString(to) +
                ", sentDate=" + sentDate +
                ", content='" + content + '\'' +
                '}';
    }
}

