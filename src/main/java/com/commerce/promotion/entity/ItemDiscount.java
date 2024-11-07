package com.commerce.promotion.entity;

public class ItemDiscount {

    String itemId;
    double itemDiscount;
    double itemTotalPrice;
    double itemActualPrice;
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public double getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(double itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public double getItemActualPrice() {
        return itemActualPrice;
    }

    public void setItemActualPrice(double itemActualPrice) {
        this.itemActualPrice = itemActualPrice;
    }
}
