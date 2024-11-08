package com.commerce.price;

import com.commerce.price.entity.Customer;
import com.commerce.price.entity.Order;
import com.commerce.price.service.OrderDiscountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
class PromotionServiceApplicationTests {

	@Autowired
	private OrderDiscountService orderDiscountService;

	@Test
	public void testRegularCustomerDiscount() throws JsonProcessingException {
        String json = "{\n" +
                "  \"orderId\": \"O1001\",\n" +
                "  \"customerId\": \"222\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"productId\": \"P123\",\n" +
                "      \"productName\": \"Smartphone\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 100.00,\n" +
                "       \"category\": \"electronic\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": \"P456\",\n" +
                "      \"productName\": \"Laptop\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 100.00,\n" +
                "      \"category\": \"electronic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalAmount\": 200.00,\n" +
                "  \"orderStatus\": \"Pending\",\n" +
                "  \"orderDate\": \"2024-11-08\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json,Order.class);
        Order discountOrder = orderDiscountService.calculateOrderDiscount(order);
		Assertions.assertEquals(5.0, discountOrder.getOrderDiscount());
        Assertions.assertEquals(185.0, discountOrder.getTotalAmountAfterDiscount());
        Assertions.assertEquals(15.0, discountOrder.getTotalDiscount());
        Assertions.assertEquals(200.0, discountOrder.getTotalAmount());
        Assertions.assertEquals(5.0, discountOrder.getItems().get(0).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(0).getPrice());
        Assertions.assertEquals(5.0, discountOrder.getItems().get(1).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(1).getPrice());
	}

    @Test
    public void testStoreCustomerDiscount() throws JsonProcessingException {
        String json = "{\n" +
                "  \"orderId\": \"O1001\",\n" +
                "  \"customerId\": \"333\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"productId\": \"P123\",\n" +
                "      \"productName\": \"Smartphone\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 100.00,\n" +
                "       \"category\": \"electronic\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": \"P456\",\n" +
                "      \"productName\": \"Laptop\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 100.00,\n" +
                "      \"category\": \"electronic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalAmount\": 200.00,\n" +
                "  \"orderStatus\": \"Pending\",\n" +
                "  \"orderDate\": \"2024-11-08\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json,Order.class);
        Order discountOrder = orderDiscountService.calculateOrderDiscount(order);
        Assertions.assertEquals(5.0, discountOrder.getOrderDiscount());
        Assertions.assertEquals(175.0, discountOrder.getTotalAmountAfterDiscount());
        Assertions.assertEquals(25.0, discountOrder.getTotalDiscount());
        Assertions.assertEquals(200.0, discountOrder.getTotalAmount());
        Assertions.assertEquals(10.0, discountOrder.getItems().get(0).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(0).getPrice());
        Assertions.assertEquals(10.0, discountOrder.getItems().get(1).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(1).getPrice());
    }

    @Test
    public void testStoreEmployeeDiscount() throws JsonProcessingException {
        String json = "{\n" +
                "  \"orderId\": \"O1001\",\n" +
                "  \"customerId\": \"111\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"productId\": \"P123\",\n" +
                "      \"productName\": \"Smartphone\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 100.00,\n" +
                "       \"category\": \"electronic\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": \"P456\",\n" +
                "      \"productName\": \"Laptop\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 100.00,\n" +
                "      \"category\": \"electronic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalAmount\": 200.00,\n" +
                "  \"orderStatus\": \"Pending\",\n" +
                "  \"orderDate\": \"2024-11-08\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json,Order.class);
        Order discountOrder = orderDiscountService.calculateOrderDiscount(order);
        Assertions.assertEquals(5.0, discountOrder.getOrderDiscount());
        Assertions.assertEquals(135.0, discountOrder.getTotalAmountAfterDiscount());
        Assertions.assertEquals(65.0, discountOrder.getTotalDiscount());
        Assertions.assertEquals(200.0, discountOrder.getTotalAmount());
        Assertions.assertEquals(30.0, discountOrder.getItems().get(0).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(0).getPrice());
        Assertions.assertEquals(30.0, discountOrder.getItems().get(1).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(1).getPrice());
    }

    @Test
    public void testNonGroceryDiscount() throws JsonProcessingException {
        String json = "{\n" +
                "  \"orderId\": \"O1001\",\n" +
                "  \"customerId\": \"333\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"productId\": \"P123\",\n" +
                "      \"productName\": \"Smartphone\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 100.00,\n" +
                "       \"category\": \"electronic\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": \"P456\",\n" +
                "      \"productName\": \"Laptop\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 100.00,\n" +
                "      \"category\": \"electronic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalAmount\": 200.00,\n" +
                "  \"orderStatus\": \"Pending\",\n" +
                "  \"orderDate\": \"2024-11-08\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json,Order.class);
        Order discountOrder = orderDiscountService.calculateOrderDiscount(order);
        Assertions.assertEquals(5.0, discountOrder.getOrderDiscount());
        Assertions.assertEquals(175.0, discountOrder.getTotalAmountAfterDiscount());
        Assertions.assertEquals(25.0, discountOrder.getTotalDiscount());
        Assertions.assertEquals(200.0, discountOrder.getTotalAmount());
        Assertions.assertEquals(10.0, discountOrder.getItems().get(0).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(0).getPrice());
        Assertions.assertEquals(10.0, discountOrder.getItems().get(1).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(1).getPrice());
    }

    @Test
    public void testSomeGroceryDiscount() throws JsonProcessingException {
        String json = "{\n" +
                "  \"orderId\": \"O1001\",\n" +
                "  \"customerId\": \"333\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"productId\": \"P123\",\n" +
                "      \"productName\": \"Smartphone\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 100.00,\n" +
                "       \"category\": \"electronic\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": \"P456\",\n" +
                "      \"productName\": \"Milk\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 100.00,\n" +
                "      \"category\": \"grocery\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalAmount\": 200.00,\n" +
                "  \"orderStatus\": \"Pending\",\n" +
                "  \"orderDate\": \"2024-11-08\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json,Order.class);
        Order discountOrder = orderDiscountService.calculateOrderDiscount(order);
        Assertions.assertEquals(5.0, discountOrder.getOrderDiscount());
        Assertions.assertEquals(185.0, discountOrder.getTotalAmountAfterDiscount());
        Assertions.assertEquals(15.0, discountOrder.getTotalDiscount());
        Assertions.assertEquals(200.0, discountOrder.getTotalAmount());
        Assertions.assertEquals(10.0, discountOrder.getItems().get(0).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(0).getPrice());
        Assertions.assertEquals(0.0, discountOrder.getItems().get(1).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(1).getPrice());
    }


    @Test
    public void testAllGroceryDiscount() throws JsonProcessingException {
        String json = "{\n" +
                "  \"orderId\": \"O1001\",\n" +
                "  \"customerId\": \"333\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"productId\": \"P123\",\n" +
                "      \"productName\": \"bread\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 100.00,\n" +
                "       \"category\": \"grocery\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": \"P456\",\n" +
                "      \"productName\": \"Milk\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 100.00,\n" +
                "      \"category\": \"grocery\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalAmount\": 200.00,\n" +
                "  \"orderStatus\": \"Pending\",\n" +
                "  \"orderDate\": \"2024-11-08\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json,Order.class);
        Order discountOrder = orderDiscountService.calculateOrderDiscount(order);
        Assertions.assertEquals(10.0, discountOrder.getOrderDiscount());
        Assertions.assertEquals(190.0, discountOrder.getTotalAmountAfterDiscount());
        Assertions.assertEquals(10.0, discountOrder.getTotalDiscount());
        Assertions.assertEquals(200.0, discountOrder.getTotalAmount());
        Assertions.assertEquals(0.0, discountOrder.getItems().get(0).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(0).getPrice());
        Assertions.assertEquals(0.0, discountOrder.getItems().get(1).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(1).getPrice());

    }


    @Test
    public void testRegularCustomerNoDiscount() throws JsonProcessingException {
        String json = "{\n" +
                "  \"orderId\": \"O1001\",\n" +
                "  \"customerId\": \"444\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"productId\": \"P123\",\n" +
                "      \"productName\": \"Smartphone\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 100.00,\n" +
                "       \"category\": \"electronic\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": \"P456\",\n" +
                "      \"productName\": \"Laptop\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 100.00,\n" +
                "      \"category\": \"electronic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalAmount\": 200.00,\n" +
                "  \"orderStatus\": \"Pending\",\n" +
                "  \"orderDate\": \"2024-11-08\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json,Order.class);
        Order discountOrder = orderDiscountService.calculateOrderDiscount(order);
        Assertions.assertEquals(10.0, discountOrder.getOrderDiscount());
        Assertions.assertEquals(190.0, discountOrder.getTotalAmountAfterDiscount());
        Assertions.assertEquals(10.0, discountOrder.getTotalDiscount());
        Assertions.assertEquals(200.0, discountOrder.getTotalAmount());
        Assertions.assertEquals(0.0, discountOrder.getItems().get(0).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(0).getPrice());
        Assertions.assertEquals(0.0, discountOrder.getItems().get(1).getDiscount());
        Assertions.assertEquals(100.0, discountOrder.getItems().get(1).getPrice());
    }

}
