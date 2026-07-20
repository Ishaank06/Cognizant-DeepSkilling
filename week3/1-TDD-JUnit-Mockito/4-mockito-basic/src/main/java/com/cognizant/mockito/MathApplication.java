package com.cognizant.mockito;

public class MathApplication {
    private CalculatorService calculatorService;

    public MathApplication(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int performAddition(int a, int b) {
        return calculatorService.add(a, b);
    }
}
