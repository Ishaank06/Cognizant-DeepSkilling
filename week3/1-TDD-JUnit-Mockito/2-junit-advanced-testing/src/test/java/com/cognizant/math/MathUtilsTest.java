package com.cognizant.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathUtilsTest {

    private final MathUtils mathUtils = new MathUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
    void testIsPrime_WithPrimeNumbers_ReturnsTrue(int number) {
        assertTrue(mathUtils.isPrime(number), number + " should be prime");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 4, 6, 8, 9, 10, 15})
    void testIsPrime_WithNonPrimeNumbers_ReturnsFalse(int number) {
        assertFalse(mathUtils.isPrime(number), number + " should not be prime");
    }
}
