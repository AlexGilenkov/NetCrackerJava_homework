package com.netcracker.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomMessage {
    private String to;
    private String from;
    private String subject;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
