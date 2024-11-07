package com.commerce.promotion.service;

import com.commerce.promotion.entity.Customer;
import com.commerce.promotion.entity.Item;
import com.commerce.promotion.entity.ItemDiscount;

public interface ItemDiscountCalculator {
   public ItemDiscount getDiscountedItemPrice(Customer customer , Item item);
}
