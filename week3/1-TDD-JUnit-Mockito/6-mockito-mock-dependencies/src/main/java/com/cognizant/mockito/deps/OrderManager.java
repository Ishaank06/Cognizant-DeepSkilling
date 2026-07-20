package com.cognizant.mockito.deps;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private UserService userService;
    private OrderService orderService;

    public OrderManager(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        List<User> users = userService.getAllUsers();
        
        for (User user : users) {
            List<Order> userOrders = orderService.getOrdersForUser(user.getId());
            if (userOrders != null) {
                allOrders.addAll(userOrders);
            }
        }
        
        return allOrders;
    }
}
