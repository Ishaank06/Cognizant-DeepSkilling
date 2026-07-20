package com.cognizant.mockito.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    @Mock
    private CalculatorService mockCalculatorService;

    @Spy
    private CalculatorService spyCalculatorService;

    @Test
    public void testArgumentMatchers() {
        // Exercise 1: Argument Matchers
        MathApplication mathApplicationWithMock = new MathApplication(mockCalculatorService);
        when(mockCalculatorService.subtract(anyInt(), anyInt())).thenReturn(50);
        when(mockCalculatorService.multiply(anyInt(), anyInt())).thenReturn(100);

        assertEquals(50, mathApplicationWithMock.performSubtract(999, 123));
        assertEquals(100, mathApplicationWithMock.performMultiply(10, 20));

        verify(mockCalculatorService).subtract(anyInt(), anyInt());
        verify(mockCalculatorService).multiply(anyInt(), anyInt());
    }

    @Test
    public void testSpying() {
        // Exercise 2: Spying
        MathApplication appWithSpy = new MathApplication(spyCalculatorService);
        
        // Override ONLY multiply
        doReturn(1000).when(spyCalculatorService).multiply(10, 10);

        // Call add (should use real method: 10 + 10 = 20)
        assertEquals(20, appWithSpy.performAdd(10, 10));

        // Call multiply (should use mocked method: 1000)
        assertEquals(1000, appWithSpy.performMultiply(10, 10));
    }
}
