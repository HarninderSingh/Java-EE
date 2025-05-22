package com.techbros.springpp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.techbros.springpp.model.Product;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public ProductService() {
        // Add some dummy products
        products.add(new Product(idCounter.incrementAndGet(), "Laptop", 800.0, "A powerful laptop", 10));
        products.add(new Product(idCounter.incrementAndGet(), "Phone", 400.0, "A smart phone", 25));
        products.add(new Product(idCounter.incrementAndGet(), "Headphones", 50.0, "Noise-cancelling headphones", 50));
    }

    public Product createProduct(Product product) {
        product.setProductId(idCounter.incrementAndGet());
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setProductName(productDetails.getProductName());
        product.setProductPrice(productDetails.getProductPrice());
        product.setProductDescription(productDetails.getProductDescription());
        product.setProductQuantity(productDetails.getProductQuantity());
        return product;
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        products.remove(product);
    }
}