package com.commerce.price.promotions;

import com.commerce.price.constants.PromotionConstants.CustomerType;
import com.commerce.price.entity.Customer;
import com.commerce.price.entity.Order;
import com.commerce.price.utils.CustomerUtils;

import java.util.ArrayList;
import java.util.List;

import static com.commerce.price.constants.PromotionConstants.GROCERY;

public class CustomerPromotion implements Promotion {
    ;
    List <String> excludeCategory =  getExcludePromoCategory();
    @Override
    public Order applyPromotion(Order order) {
        double discountPercentage = getCustomerDiscountPercentage(CustomerUtils.getCustomerItem(order.getCustomerId()));
       if( discountPercentage > 0.0) {
           order.getItems().stream().filter(item -> ! excludeCategory.contains(item.getCategory())).forEach(
                   item -> {
                       double discount = (item.getPrice() * discountPercentage) / 100;
                       item.setDiscount(discount);
                   }
           );
       }
        return order;
    }

    private double getCustomerDiscountPercentage(Customer customer) {
        double discount = 0;
        if (String.valueOf(CustomerType.EMPLOYEE).equals(customer.getCustomerType())) {
            discount = 30;
        } else if (String.valueOf(CustomerType.STORE).equals(customer.getCustomerType())) {
            discount = 10;
        } else if (String.valueOf(CustomerType.REGULAR).equals(customer.getCustomerType())
                && customer.getDurationYears() >= 2) {
            discount = 5;
        }
        return discount;
    }

    private List <String> getExcludePromoCategory() {
        List <String> excludeCategory = new ArrayList<String>();
        excludeCategory.add(GROCERY);
        return excludeCategory;
    }
}


