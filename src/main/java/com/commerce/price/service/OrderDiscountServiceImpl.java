package com.commerce.price.service;

import com.commerce.price.entity.Order;
import com.commerce.price.promotions.CustomerPromotion;
import com.commerce.price.promotions.OrderPromotion;
import com.commerce.price.promotions.Promotion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDiscountServiceImpl implements OrderDiscountService {

    List<Promotion> promoList = getOrderPromotioList();
    @Override
    public Order calculateOrderDiscount(Order order) {

        for (Promotion promotion : promoList) {
            order = promotion.applyPromotion(order);
        }
        return order;

    }

    private List<Promotion> getOrderPromotioList() {
        List<Promotion> promoList = new ArrayList<Promotion>();
        promoList.add(new CustomerPromotion());
        promoList.add(new OrderPromotion());
        return promoList;
    }

}
