package com.commerce.promotion.entity;

public class Item {

    protected  String name;
    protected  String itemId;
    protected  String category;
    protected  Double totalPrice;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
