package com.commerce.promotion.controller;


import com.commerce.promotion.entity.ItemDiscount;
import com.commerce.promotion.service.CommonService;
import com.commerce.promotion.service.ItemDiscountCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion")
public class PromotionDiscount {
 @Autowired
 ItemDiscountCalculator itemDiscount;
 @Autowired
 CommonService commonService;

 @GetMapping("/item-discount")
 ItemDiscount getItemDiscount(@RequestParam("userId") String userId , @RequestParam("itemId") String itemId) {
  return itemDiscount.getDiscountedItemPrice(commonService.getCustomerItem(userId),commonService.getItem(itemId));
 }

}
