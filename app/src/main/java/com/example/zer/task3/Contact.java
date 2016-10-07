package com.example.zer.task3;

import java.io.Serializable;

public class Contact implements Serializable {

    private String name;
    private String email;
    private String address;
    private String phone;
    private int image;

    public Contact(String name, String email, String address, String phone, int image) {

        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getImage() {
        return image;
    }
}
