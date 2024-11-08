package com.commerce.price.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.commerce.price.entity.Order;
import com.commerce.price.service.OrderDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotion")
public class OrderDiscountController {
 private static final Logger logger = LoggerFactory.getLogger(OrderDiscountController.class);
 @Autowired
 OrderDiscountService discountService;

 @PostMapping("/apply-discount")
 Order applyOrderDiscount(@RequestBody Order order) {
  logger.info("Received order for discount :"+order.getOrderId());
  return discountService.calculateOrderDiscount(order);
 }
}
