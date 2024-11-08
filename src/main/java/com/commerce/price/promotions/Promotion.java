package com.commerce.price.promotions;

import com.commerce.price.entity.Order;

public interface Promotion {
    Order applyPromotion(Order order);
}
