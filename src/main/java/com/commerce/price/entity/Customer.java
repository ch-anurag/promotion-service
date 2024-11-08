package com.commerce.price.entity;


public class Customer {
    protected String id;
    protected String name;
    protected int durationYears;
    protected String customerType;
    public Customer(String id ,String name,String customerType,int durationYears) {
        this.id = id;
        this.name = name;
        this.customerType =customerType;
        this.durationYears = durationYears;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDurationYears() {
        return durationYears;
    }

    public String getName() {
        return name;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}