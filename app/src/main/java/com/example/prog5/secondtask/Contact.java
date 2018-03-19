package com.example.prog5.secondtask;

/**
 * Created by prog5 on 3/19/2018.
 */

public class Contact {
    private String name;
    private int phone, imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Contact() {

    }

    public Contact(String name, int phone, int imageId) {

        this.name = name;
        this.phone = phone;
        this.imageId = imageId;
    }
}
