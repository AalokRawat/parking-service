package com.service01;

/**
 * Created by aalokr on 12/10/17.
 */

class Form {

    private String number;
    private String type;

    public Form() {
    }

    public Form(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
