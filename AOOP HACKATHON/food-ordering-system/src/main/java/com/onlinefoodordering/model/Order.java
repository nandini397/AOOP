package com.onlinefoodordering.model;

public class Order {
    private String itemName; // Name of the food item
    private double price; // Price of the food item
    private int quantity; // Quantity of the food item

    // Constructor
    public Order(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter for price
    public double getPrice() {
        return price * quantity; // Total price for the item based on quantity
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
