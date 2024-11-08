package com.commerce.price.service;

import com.commerce.price.entity.Order;

public interface OrderDiscountService {
   public Order calculateOrderDiscount(Order order);
}
