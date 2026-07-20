package com.cognizant.mockito.advanced;

public class MathApplication {
    private CalculatorService calculatorService;

    public MathApplication(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int performAdd(int a, int b) {
        return calculatorService.add(a, b);
    }

    public int performSubtract(int a, int b) {
        return calculatorService.subtract(a, b);
    }

    public int performMultiply(int a, int b) {
        return calculatorService.multiply(a, b);
    }
}
