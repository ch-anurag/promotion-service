package com.commerce.price.utils;

import com.commerce.price.constants.PromotionConstants;
import com.commerce.price.entity.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerUtils {
    private static final Map<String, Customer> customerDataMap = new HashMap<String, Customer>();

    static {
        Customer customer1 = new Customer("1111", "Ankit", String.valueOf(PromotionConstants.CustomerType.EMPLOYEE), 2);
        Customer customer2 = new Customer("222", "Amit", String.valueOf(PromotionConstants.CustomerType.REGULAR), 3);
        Customer customer3 = new Customer("333", "Ajay", String.valueOf(PromotionConstants.CustomerType.STORE), 3);
        Customer customer4 = new Customer("444", "Anuj", String.valueOf(PromotionConstants.CustomerType.REGULAR), 1);
        customerDataMap.put("111", customer1);
        customerDataMap.put("222", customer2);
        customerDataMap.put("333", customer3);
        customerDataMap.put("444", customer4);
    }

      public static Customer getCustomerItem(String CustomerId) {
        return customerDataMap.get(CustomerId);

    }

}
