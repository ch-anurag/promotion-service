package com.commerce.promotion.service;

import com.commerce.promotion.entity.Customer;
import com.commerce.promotion.entity.Item;
import com.commerce.promotion.entity.ItemDiscount;
import com.commerce.promotion.entity.RegularCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDiscountCalculatorImpl implements ItemDiscountCalculator {
    @Autowired
    public  TotalAmountFixedDiscountPromotion fixedDiscount;
    @Override
    public ItemDiscount getDiscountedItemPrice(Customer customer , Item item) {
        double customerDiscount = customer.applyCustomerDiscount(item);
        double flatDiscount =  fixedDiscount.calculateDiscountAmount(item);
        ItemDiscount itemDiscount = new ItemDiscount();
        double totalDiscount  = customerDiscount + flatDiscount;
        itemDiscount.setItemDiscount(totalDiscount);
        itemDiscount.setItemTotalPrice(item.getTotalPrice());
        itemDiscount.setItemId(item.getItemId());
        itemDiscount.setItemActualPrice(item.getTotalPrice() -totalDiscount);
        return itemDiscount ;
    }
}
