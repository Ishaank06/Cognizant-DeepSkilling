package com.cognizant.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private MathApplication mathApplication;

    @Test
    public void testPerformAddition() {
        // Arrange
        int a = 10;
        int b = 20;
        when(calculatorService.add(a, b)).thenReturn(30);

        // Act
        int result = mathApplication.performAddition(a, b);

        // Assert
        assertEquals(30, result, "The addition result should match the mocked value");
        verify(calculatorService).add(a, b);
    }
}
