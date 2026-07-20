package com.cognizant.mockito.deps;
import java.util.List;

public interface OrderService {
    List<Order> getOrdersForUser(String userId);
}
