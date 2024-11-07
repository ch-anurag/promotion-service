package com.commerce.promotion.service;

import ch.qos.logback.core.pattern.util.IEscapeUtil;
import com.commerce.promotion.data.pojo.CustomerData;
import com.commerce.promotion.data.pojo.ItemData;
import com.commerce.promotion.entity.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CommonServiceImpl implements  CommonService{
    public enum CustomerType {
        EMPLOYEE,
        STORE,
        REGULAR
    }
    private static final Map<String,CustomerData> customerDataMap = new HashMap<String,CustomerData>();
    private static final Map<String, ItemData> itemDataMap = new HashMap<String,ItemData>();
    static {
            CustomerData customer1 = new CustomerData();
            customer1.setName("ankit");
            customer1.setCustomerType(String.valueOf(CustomerType.EMPLOYEE));
            customer1.setDurationYears(1);
            CustomerData customer2 = new CustomerData();
            customer2.setName("amit");
            customer2.setCustomerType(String.valueOf(CustomerType.REGULAR));
            customer2.setDurationYears(3);
            CustomerData customer3 = new CustomerData();
            customer3.setName("aditya");
            customer3.setCustomerType(String.valueOf(CustomerType.STORE));
            customer3.setDurationYears(3);
            CustomerData customer4 = new CustomerData();
            customer4.setName("aayush");
            customer4.setCustomerType(String.valueOf(CustomerType.REGULAR));
            customer4.setDurationYears(1);
            customerDataMap.put("111",customer1);
            customerDataMap.put("222",customer2);
            customerDataMap.put("333",customer3);
            customerDataMap.put("444",customer4);
            ItemData item1 = new ItemData();
            item1.setName("laptop");
            item1.setCategory("electronic");
            item1.setItemId("111");
            item1.setTotalPrice(500.0);
            ItemData item2 = new ItemData();
            item2.setName("milk");
            item2.setCategory("groceries");
            item2.setItemId("222");
            item2.setTotalPrice(300.0);
            itemDataMap.put("111",item1);
            itemDataMap.put("222",item2);
    }

    @Override
    public Customer getCustomerItem(String CustomerId) {
        CustomerData customData =  customerDataMap.get(CustomerId);
        Customer customer = null;
        if (String.valueOf(CustomerType.REGULAR).equals(customData.getCustomerType())) {
            customer = new RegularCustomer(customData.getName(),customData.getDurationYears());
        } else if (String.valueOf(CustomerType.EMPLOYEE).equals(customData.getCustomerType())) {
            customer = new StoreEmployee(customData.getName(),customData.getDurationYears());
        } else if (String.valueOf(CustomerType.STORE).equals(customData.getCustomerType())) {
            customer = new StoreCustomer(customData.getName(),customData.getDurationYears());
        }
        return customer;
    }

    @Override
    public Item getItem(String itemId) {
        ItemData itemData = itemDataMap.get(itemId);
        Item item = new Item();
        item.setCategory(itemData.getCategory());
        item.setName(itemData.getName());
        item.setTotalPrice(itemData.getTotalPrice());
        item.setItemId(itemData.getItemId());
        return item;
    }


}
