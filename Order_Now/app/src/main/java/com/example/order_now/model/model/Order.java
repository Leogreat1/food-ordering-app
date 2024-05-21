package com.example.foodorderapp.model;

public class Order {
    private int id;
    private int userId;
    private String item;
    private int quantity;

    public Order() {
    }

    public Order(int id, int userId, String item, int quantity) {
        this.id = id;
        this.userId = userId;
        this.item = item;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
