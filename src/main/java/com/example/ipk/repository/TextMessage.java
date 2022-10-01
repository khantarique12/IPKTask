package com.example.ipk.repository;

import javax.persistence.*;

@Entity
@Table(name="textmessage")
public class TextMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String contact;

    private String textMessage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}

