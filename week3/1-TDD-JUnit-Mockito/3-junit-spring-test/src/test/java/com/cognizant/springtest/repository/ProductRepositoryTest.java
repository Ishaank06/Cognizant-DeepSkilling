package com.cognizant.springtest.repository;

import com.cognizant.springtest.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveAndFindById_ReturnsProduct() {
        // Arrange
        Product product = new Product("Laptop", 1200.00);

        // Act
        Product savedProduct = productRepository.save(product);
        Optional<Product> retrievedProduct = productRepository.findById(savedProduct.getId());

        // Assert
        assertTrue(retrievedProduct.isPresent(), "Product should be present in database");
        assertEquals("Laptop", retrievedProduct.get().getName(), "Product name should match");
    }
}
