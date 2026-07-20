package com.cognizant.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathApplication {
    private static final Logger logger = LoggerFactory.getLogger(MathApplication.class);

    public int add(int a, int b) {
        logger.trace("Entering add method with a={} and b={}", a, b);
        logger.debug("Debugging add method execution");
        logger.info("Adding two integers: {} + {}", a, b);
        
        int result = a + b;
        
        if (result < 0) {
            logger.warn("The result is negative, this might be unexpected.");
        }
        
        if (a == 0 && b == 0) {
            logger.error("Both numbers are zero!");
        }
        
        logger.debug("Exiting add method with result={}", result);
        return result;
    }

    public static void main(String[] args) {
        logger.info("Starting MathApplication...");
        MathApplication app = new MathApplication();
        int sum = app.add(2, 3);
        logger.info("Final Sum: {}", sum);
    }
}
