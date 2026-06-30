package com.example.search;

public class SearchAlgorithms {

    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product != null && product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Product midProduct = sortedProducts[mid];
            int cmp = midProduct.getProductId().compareTo(targetId);

            if (cmp == 0) {
                return midProduct;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
