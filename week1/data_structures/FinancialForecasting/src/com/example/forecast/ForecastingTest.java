package com.example.forecast;

public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Financial Forecasting ===");

        double presentValue = 1000.0;
        double growthRate = 0.05;
        int periods = 10;

        System.out.println("Initial Investment: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Period: " + periods + " years\n");

        double fvRecursive = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("Recursive Forecast: $%.2f%n", fvRecursive);

        double fvIterative = FinancialForecasting.calculateFutureValueIterative(presentValue, growthRate, periods);
        System.out.printf("Iterative Forecast: $%.2f%n", fvIterative);

        double fvMemoized = FinancialForecasting.calculateFutureValueMemoized(presentValue, growthRate, periods);
        System.out.printf("Memoized Forecast:  $%.2f%n", fvMemoized);

        System.out.println("\n--- Testing Recursion Limits with Large Periods (e.g., 20,000 periods) ---");
        int largePeriods = 20000;

        try {
            long startTime = System.nanoTime();
            double result = FinancialForecasting.calculateFutureValueIterative(presentValue, growthRate, largePeriods);
            long duration = System.nanoTime() - startTime;
            System.out.println("Iterative approach succeeded in " + (duration / 1_000_000.0) + " ms.");
        } catch (Throwable t) {
            System.out.println("Iterative approach failed: " + t.getClass().getSimpleName());
        }

        try {
            System.out.println("Running recursive approach...");
            FinancialForecasting.calculateFutureValue(presentValue, growthRate, largePeriods);
            System.out.println("Recursive approach succeeded.");
        } catch (StackOverflowError e) {
            System.err.println("CRITICAL FAILURE: Recursive approach triggered a StackOverflowError!");
            System.err.println("Reason: Too many recursion stack frames allocated in the call stack memory.");
        }
    }
}
