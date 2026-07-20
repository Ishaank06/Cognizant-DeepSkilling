package com.cognizant.mockito.deps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderManagerTest {

    @Mock
    private UserService userService;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderManager orderManager;

    @Test
    public void testGetAllOrders_ReturnsAggregatedList() {
        // Arrange
        User u1 = new User("u1");
        User u2 = new User("u2");
        when(userService.getAllUsers()).thenReturn(Arrays.asList(u1, u2));

        when(orderService.getOrdersForUser("u1"))
            .thenReturn(Arrays.asList(new Order("o1"), new Order("o2")));
            
        when(orderService.getOrdersForUser("u2"))
            .thenReturn(Arrays.asList(new Order("o3"), new Order("o4")));

        // Act
        List<Order> allOrders = orderManager.getAllOrders();

        // Assert
        assertEquals(4, allOrders.size(), "Total orders aggregated should be exactly 4");
        
        verify(userService, times(1)).getAllUsers();
        verify(orderService, times(1)).getOrdersForUser("u1");
        verify(orderService, times(1)).getOrdersForUser("u2");
    }
}
