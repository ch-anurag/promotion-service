package com.commerce.promotion.service;

import com.commerce.promotion.entity.Item;
import org.springframework.stereotype.Service;

@Service
public class TotalAmountFixedDiscountPromotion implements Promotion{
    int discountAmount =5;
    int discountOnPrice =100;

    @Override
    public double calculateDiscountAmount(Item item) {
      return ((int) (item.getTotalPrice()/discountOnPrice))*discountAmount;

    }
}
