package com.commerce.promotion.service;

import com.commerce.promotion.entity.Item;

public interface Promotion {
    double calculateDiscountAmount(Item item);
}