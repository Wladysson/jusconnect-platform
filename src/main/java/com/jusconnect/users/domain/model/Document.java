package com.jusconnect.users.domain.model;

public class Document {

    private String type; // CPF, RG, OAB, etc
    private String number;
    private String url;

    public Document() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}