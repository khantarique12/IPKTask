package com.example.ipk.dto;

public class TextMessageDto {

    private long id;
    private String contact;
    private String text;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextMessageDto{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
