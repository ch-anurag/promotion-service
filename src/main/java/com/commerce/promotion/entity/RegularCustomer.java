package com.commerce.promotion.entity;

public class RegularCustomer  extends  Customer {
    protected  int percentageDiscount = 5;
    public RegularCustomer(String name, int durationYears) {
        super(name, durationYears);
    }

    @Override
    public double applyCustomerDiscount(Item item) {
        double discountPrice = 0;
       if(durationYears > 2 && ! excludeCategory.equals(item.getCategory())) {
           discountPrice =  (item.getTotalPrice() * percentageDiscount) / 100;
       }
        return discountPrice;
    }
}
