package com.example.miles.fitness4u;

/**
 * Created by miles on 5/16/2018.
 */

public class DashModel {
    private String head;
    private int image;

    public DashModel() {
    }

    public DashModel(String head, int image) {
        this.head = head;
        this.image = image;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
