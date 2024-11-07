package com.commerce.promotion.entity;

public class StoreEmployee extends Customer{
    protected  int percentageDiscount = 30;
    public StoreEmployee(String name, int durationYears) {
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
