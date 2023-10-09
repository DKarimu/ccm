package com.dari.ccm.entitys;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emailId;
    private String subject;
    private String[] sender;
    private String[] receiver;
    private Date sentDate;
    private String content;

    public Email(String subject, String[] from, String[] to, Date sentDate, String content) {
        this.subject = subject;
        this.sender = from;
        this.receiver = to;
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

    public String[] getSender() {
        return sender;
    }

    public void setSender(String[] sender) {
        this.sender = sender;
    }

    public String[] getReceiver() {
        return receiver;
    }

    public void setReceiver(String[] receiver) {
        this.receiver = receiver;
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
                ", from=" + Arrays.toString(sender) +
                ", to=" + Arrays.toString(receiver) +
                ", sentDate=" + sentDate +
                ", content='" + content + '\'' +
                '}';
    }
}