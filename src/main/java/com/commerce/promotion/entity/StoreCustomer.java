package com.commerce.promotion.entity;

public class StoreCustomer extends Customer{
    protected  int percentageDiscount = 10;
    public StoreCustomer(String name, int durationYears) {
        super(name, durationYears);
    }

    @Override
    public double applyCustomerDiscount(Item item) {
        double discountPrice = 0;
        if (!excludeCategory.equals(item.getCategory())) {
            discountPrice =  (item.getTotalPrice() * percentageDiscount) / 100;
        }
        return discountPrice;
    }
}
