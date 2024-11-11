package com.onlinefoodordering.controller;

import com.onlinefoodordering.model.Order;
import com.onlinefoodordering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private List<Order> orders = new ArrayList<>(); // List to hold orders

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService; // Dependency injection of OrderService
    }

    /**
     * Display the order form.
     */
    @GetMapping("/order")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order("", 0.0, 1)); // Initialize a new Order object
        return "order-form"; // Returns the view name for the order form
    }

    /**
     * Submit an order and calculate totals, tax, and discounts.
     *
     * @param order the order to be submitted
     * @param model the model to hold attributes for the view
     * @return the view name to display the orders and calculations
     */
    @PostMapping("/submitOrder")
    public String submitOrder(@ModelAttribute Order order, Model model) {
        orders.add(order); // Add the submitted order to the list
        
        double total = orderService.calculateTotal(orders); // Calculate total
        double tax = orderService.calculateTax(total); // Calculate tax
        double discount = orderService.applyDiscount(total); // Apply discount
        double finalAmount = total + tax - discount; // Final amount after tax and discount
        
        // Adding calculated details to the model
        model.addAttribute("orders", orders);
        model.addAttribute("total", total);
        model.addAttribute("tax", tax);
        model.addAttribute("discount", discount);
        model.addAttribute("finalAmount", finalAmount);
        
        return "view-orders"; // Returns the view name to display the orders and calculated details
    }

    /**
     * Display the order history (optional).
     */
    @GetMapping("/viewOrders")
    public String viewOrders(Model model) {
        model.addAttribute("orders", orders); // Pass the list of orders to the model
        return "view-orders"; // Returns the view name to display the orders
    }
}
