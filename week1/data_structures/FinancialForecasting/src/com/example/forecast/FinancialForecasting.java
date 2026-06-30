package com.example.forecast;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    private static final Map<Integer, Double> memoCache = new HashMap<>();

    public static double calculateFutureValue(double pv, double rate, int periods) {
        if (periods == 0) {
            return pv;
        }
        return (1 + rate) * calculateFutureValue(pv, rate, periods - 1);
    }

    public static double calculateFutureValueIterative(double pv, double rate, int periods) {
        double futureValue = pv;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + rate);
        }
        return futureValue;
    }

    public static double calculateFutureValueMemoized(double pv, double rate, int periods) {
        if (periods == 0) {
            return pv;
        }
        if (memoCache.containsKey(periods)) {
            return memoCache.get(periods);
        }
        double result = (1 + rate) * calculateFutureValueMemoized(pv, rate, periods - 1);
        memoCache.put(periods, result);
        return result;
    }

    public static void clearCache() {
        memoCache.clear();
    }
}
