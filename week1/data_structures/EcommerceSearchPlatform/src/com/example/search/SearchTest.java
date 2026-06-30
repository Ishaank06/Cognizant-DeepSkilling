package com.example.search;

import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== Testing E-commerce Search Function ===");

        Product[] products = {
            new Product("P105", "Wireless Mouse", "Electronics"),
            new Product("P101", "Mechanical Keyboard", "Electronics"),
            new Product("P103", "Leather Wallet", "Accessories"),
            new Product("P102", "Running Shoes", "Footwear"),
            new Product("P104", "Water Bottle", "Sports & Outdoors")
        };

        System.out.println("Initial Unsorted Product Catalog:");
        for (Product p : products) {
            System.out.println("  " + p);
        }

        String searchTargetId = "P103";

        System.out.println("\n--- Testing Linear Search ---");
        Product resultLS = SearchAlgorithms.linearSearch(products, searchTargetId);
        System.out.println("Searching for: " + searchTargetId);
        System.out.println("Found: " + resultLS);

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts);

        System.out.println("\nSorted Product Catalog (for Binary Search):");
        for (Product p : sortedProducts) {
            System.out.println("  " + p);
        }

        System.out.println("\n--- Testing Binary Search ---");
        Product resultBS = SearchAlgorithms.binarySearch(sortedProducts, searchTargetId);
        System.out.println("Searching for: " + searchTargetId);
        System.out.println("Found: " + resultBS);

        System.out.println("\n=== Benchmarking Search Performance (1,000,000 lookups) ===");

        for (int i = 0; i < 50000; i++) {
            SearchAlgorithms.linearSearch(products, "P104");
            SearchAlgorithms.binarySearch(sortedProducts, "P104");
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            SearchAlgorithms.linearSearch(products, "P104");
        }
        long durationLS = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            SearchAlgorithms.binarySearch(sortedProducts, "P104");
        }
        long durationBS = System.nanoTime() - startTime;

        System.out.println("Linear Search total time: " + (durationLS / 1_000_000.0) + " ms");
        System.out.println("Binary Search total time: " + (durationBS / 1_000_000.0) + " ms");
        System.out.println("Performance Ratio: Linear Search took " + String.format("%.2f", (double) durationLS / durationBS) + "x longer.");
    }
}
