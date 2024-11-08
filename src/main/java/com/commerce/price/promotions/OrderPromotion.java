package com.commerce.price.promotions;

import com.commerce.price.entity.Order;
import com.commerce.price.entity.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderPromotion implements Promotion {
    private static final Logger logger = LoggerFactory.getLogger(OrderPromotion.class);
    double discountAmount = 5.0;
    double discountOnPrice =100.0;
    @Override
    public Order applyPromotion(Order order) {
        logger.info("Applying the OrderPromotion for order"+order.getOrderId());
        double totalItemDiscount = order.getItems().stream().mapToDouble(OrderItem::getDiscount).sum();
        double orderDiscount = ((int)((order.getTotalAmount() - totalItemDiscount)/discountOnPrice))*discountAmount;
        double totalDiscount = orderDiscount +totalItemDiscount;
        order.setTotalAmountAfterDiscount(order.getTotalAmount() - totalDiscount);
        order.setOrderDiscount(orderDiscount);
        order.setTotalDiscount(totalDiscount);
        logger.info("orderDiscount"+orderDiscount);
        logger.info("orderDiscount"+totalDiscount);
        return order;
    }
}
