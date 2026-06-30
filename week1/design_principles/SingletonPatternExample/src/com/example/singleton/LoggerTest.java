package com.example.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;

public class LoggerTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern Implementation ===");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message via logger1.");
        logger2.log("Second log message via logger2.");

        System.out.println("\nChecking if both references point to the same object in memory...");
        System.out.println("logger1 hashcode: " + System.identityHashCode(logger1));
        System.out.println("logger2 hashcode: " + System.identityHashCode(logger2));

        if (logger1 == logger2) {
            System.out.println("SUCCESS: logger1 and logger2 are the exact same instance.");
        } else {
            System.out.println("FAILURE: logger1 and logger2 are different instances!");
        }

        System.out.println("\n=== Testing Singleton in Multi-threaded Environment ===");
        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<Integer> hashCodes = ConcurrentHashMap.newKeySet();

        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            executor.submit(() -> {
                Logger threadLogger = Logger.getInstance();
                int hashCode = System.identityHashCode(threadLogger);
                hashCodes.add(hashCode);
                threadLogger.log("Log from Thread-" + threadId + " | Instance HashCode: " + hashCode);
            });
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("\nNumber of unique Logger instances created: " + hashCodes.size());
                if (hashCodes.size() == 1) {
                    System.out.println("SUCCESS: Only one instance was shared across all " + threadCount + " threads.");
                } else {
                    System.out.println("FAILURE: Multiple Logger instances detected in a concurrent environment!");
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Thread pool execution interrupted: " + e.getMessage());
        }
    }
}
