package com.techbros.springpp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techbros.springpp.dao.ProductDao;
import com.techbros.springpp.exception.ProductNotFoundException;
import com.techbros.springpp.model.Product;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public Product createProduct(Product product) {
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        return productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productDao.findById(id)
                .orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setProductName(productDetails.getProductName());
        product.setProductPrice(productDetails.getProductPrice());
        product.setProductDescription(productDetails.getProductDescription());
        product.setProductQuantity(productDetails.getProductQuantity());
        return productDao.update(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        getProductById(id); // Throws if not found
        productDao.deleteById(id);
    }
}