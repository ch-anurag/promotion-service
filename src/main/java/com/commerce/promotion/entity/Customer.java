package com.commerce.promotion.entity;


public abstract  class Customer {
    protected String name;
    protected int durationYears;
    protected String excludeCategory = "groceries";

    public Customer(String name,int durationYears) {
        this.name = name;
        this.durationYears = durationYears;
    }

    public abstract double applyCustomerDiscount(Item item);

    public int getDurationYears() {
        return durationYears;
    }

    public String getName() {
        return name;
    }
}