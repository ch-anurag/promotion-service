package com.commerce.price.promotions;

import com.commerce.price.entity.Order;
import com.commerce.price.entity.OrderItem;

public class OrderPromotion implements Promotion {
    double discountAmount = 5.0;
    double discountOnPrice =100.0;
    @Override
    public Order applyPromotion(Order order) {
        double totalItemDiscount = order.getItems().stream().mapToDouble(OrderItem::getDiscount).sum();
        double orderDiscount = ((int)((order.getTotalAmount() - totalItemDiscount)/discountOnPrice))*discountAmount;
        double totalDiscount = orderDiscount +totalItemDiscount;
        order.setTotalAmountAfterDiscount(order.getTotalAmount() - totalDiscount);
        order.setOrderDiscount(orderDiscount);
        order.setTotalDiscount(totalDiscount);
        return order;
    }
}
