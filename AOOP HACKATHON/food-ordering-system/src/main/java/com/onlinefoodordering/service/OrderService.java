package com.onlinefoodordering.service;

import com.onlinefoodordering.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    /**
     * Calculates the total price of all orders.
     *
     * @param orders the list of orders
     * @return the total price
     */
    public double calculateTotal(List<Order> orders) {
        return orders.stream()
                     .mapToDouble(Order::getPrice) // Assuming Order has a getPrice() method
                     .sum();
    }

    /**
     * Calculates the tax based on the total amount.
     *
     * @param total the total amount before tax
     * @return the calculated tax
     */
    public double calculateTax(double total) {
        return total * 0.1; // 10% tax rate
    }

    /**
     * Applies a discount based on the total amount.
     *
     * @param total the total amount before discount
     * @return the discount amount
     */
    public double applyDiscount(double total) {
        if (total > 100) { // Example condition for discount
            return total * 0.05; // 5% discount for orders over $100
        }
        return 0; // No discount for orders $100 or less
    }
}
