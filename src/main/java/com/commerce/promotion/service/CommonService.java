package com.commerce.promotion.service;

import com.commerce.promotion.entity.Customer;
import com.commerce.promotion.entity.Item;

public interface CommonService {
    public Customer getCustomerItem(String CustomerId);
    public Item getItem(String itemId);
}
