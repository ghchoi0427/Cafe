package com.choi.cafe.data.model;

public class Merchandise {

    private String serialNumber;
    private String name;
    private String price;

    public Merchandise(String serialNumber, String name, String price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
