package com.commerce.promotion;

import com.commerce.promotion.entity.*;
import com.commerce.promotion.service.CommonService;
import com.commerce.promotion.service.ItemDiscountCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
class PromotionServiceApplicationTests {

	@Autowired
	private ItemDiscountCalculator itemDiscountCalculator;

	@Autowired
	private CommonService commonService;

	@Test
	public void testRegularCustomerDiscount() {
		Customer customer = new RegularCustomer("ankit",3);
		Item item = new Item();
		item.setItemId("111");
		item.setCategory("accessories");
		item.setTotalPrice(300.0);
		ItemDiscount itemDiscount = itemDiscountCalculator.getDiscountedItemPrice(customer,item);
		Assertions.assertEquals("111", itemDiscount.getItemId());
		Assertions.assertEquals(300.0, itemDiscount.getItemTotalPrice());
		Assertions.assertEquals(270.0, itemDiscount.getItemActualPrice());
		Assertions.assertEquals(30.0, itemDiscount.getItemDiscount());
	}

	@Test
	public void testStoreEmployeeDiscount() {
		Customer customer = new StoreEmployee("amit",3);
		Item item = new Item();
		item.setItemId("222");
		item.setCategory("accessories");
		item.setTotalPrice(200.0);
		ItemDiscount itemDiscount = itemDiscountCalculator.getDiscountedItemPrice(customer,item);
		Assertions.assertEquals("222", itemDiscount.getItemId());
		Assertions.assertEquals(200.0, itemDiscount.getItemTotalPrice());
		Assertions.assertEquals(130.0, itemDiscount.getItemActualPrice());
		Assertions.assertEquals(70.0, itemDiscount.getItemDiscount());
	}

	@Test
	public void testStoreCustomerDiscount() {
		Customer customer = new StoreCustomer("ankit",3);
		Item item = new Item();
		item.setItemId("111");
		item.setCategory("accessories");
		item.setTotalPrice(400.0);
		ItemDiscount itemDiscount = itemDiscountCalculator.getDiscountedItemPrice(customer,item);
		Assertions.assertEquals("111", itemDiscount.getItemId());
		Assertions.assertEquals(400.0, itemDiscount.getItemTotalPrice());
		Assertions.assertEquals(340, itemDiscount.getItemActualPrice());
		Assertions.assertEquals(60.0, itemDiscount.getItemDiscount());
	}

	@Test
	public void testRegularCustomerGroceriesDiscount() {
		Customer customer = new RegularCustomer("ankit",3);
		Item item = new Item();
		item.setItemId("111");
		item.setCategory("groceries");
		item.setName("butter");
		item.setTotalPrice(200.0);
		ItemDiscount itemDiscount = itemDiscountCalculator.getDiscountedItemPrice(customer,item);
		Assertions.assertEquals("111", itemDiscount.getItemId());
		Assertions.assertEquals(200.0, itemDiscount.getItemTotalPrice());
		Assertions.assertEquals(190.0, itemDiscount.getItemActualPrice());
		Assertions.assertEquals(10.0, itemDiscount.getItemDiscount());
	}

	@Test
	public void testStoreEmployeeGroceriesDiscount() {
		Customer customer = new StoreEmployee("amit",3);
		Item item = new Item();
		item.setItemId("222");
		item.setCategory("groceries");
		item.setName("butter");
		item.setTotalPrice(200.0);
		ItemDiscount itemDiscount = itemDiscountCalculator.getDiscountedItemPrice(customer,item);
		Assertions.assertEquals("222", itemDiscount.getItemId());
		Assertions.assertEquals(200.0, itemDiscount.getItemTotalPrice());
		Assertions.assertEquals(190.0, itemDiscount.getItemActualPrice());
		Assertions.assertEquals(10.0, itemDiscount.getItemDiscount());
	}

	@Test
	public void testStoreCustomerGroceriesDiscount() {
		Customer customer = new StoreCustomer("ankit",3);
		Item item = new Item();
		item.setItemId("111");
		item.setCategory("groceries");
		item.setName("butter");
		item.setTotalPrice(200.0);
		ItemDiscount itemDiscount = itemDiscountCalculator.getDiscountedItemPrice(customer,item);
		Assertions.assertEquals("111", itemDiscount.getItemId());
		Assertions.assertEquals(200.0, itemDiscount.getItemTotalPrice());
		Assertions.assertEquals(190, itemDiscount.getItemActualPrice());
		Assertions.assertEquals(10.0, itemDiscount.getItemDiscount());
	}


	@Test
	public void testRegularCustomerDurationDiscount() {
		Customer customer = new RegularCustomer("ankit",1);
		Item item = new Item();
		item.setItemId("111");
		item.setCategory("accessories");
		item.setName("charger");
		item.setTotalPrice(200.0);
		ItemDiscount itemDiscount = itemDiscountCalculator.getDiscountedItemPrice(customer,item);
		Assertions.assertEquals("111", itemDiscount.getItemId());
		Assertions.assertEquals(200.0, itemDiscount.getItemTotalPrice());
		Assertions.assertEquals(190.0, itemDiscount.getItemActualPrice());
		Assertions.assertEquals(10.0, itemDiscount.getItemDiscount());
	}


	@Test
	public void testGetStoreEmployeeItem() {
		Customer customer = commonService.getCustomerItem("111");
		Assertions.assertEquals("ankit", customer.getName());
		Assertions.assertEquals(1, customer.getDurationYears());
		Assertions.assertEquals("com.commerce.promotion.entity.StoreEmployee", customer.getClass().getName());

	}

	@Test
	public void testGetRegularCustomerItem() {
		Customer customer = commonService.getCustomerItem("222");
		Assertions.assertEquals("amit", customer.getName());
		Assertions.assertEquals(3, customer.getDurationYears());
		Assertions.assertEquals("com.commerce.promotion.entity.RegularCustomer", customer.getClass().getName());

	}

	@Test
	public void testGetStoreCustomerItem() {
		Customer customer = commonService.getCustomerItem("333");
		Assertions.assertEquals("aditya", customer.getName());
		Assertions.assertEquals(3, customer.getDurationYears());
		Assertions.assertEquals("com.commerce.promotion.entity.StoreCustomer", customer.getClass().getName());
	}

	@Test
	public void testGetItem() {
		Item item = commonService.getItem("111");
		Assertions.assertEquals("111",item.getItemId());
		Assertions.assertEquals(500.0, item.getTotalPrice());
		Assertions.assertEquals("laptop", item.getName());
		Assertions.assertEquals("electronic", item.getCategory());
	}


}
