package com.choi.cafe.data.model;

public class Customer {

    private String customerNumber;
    private String name;
    private String telNumber;

    public Customer(String customerNumber, String name, String telNumber) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.telNumber = telNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

}
