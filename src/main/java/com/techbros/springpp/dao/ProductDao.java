package com.techbros.springpp.dao;

import java.util.List;
import java.util.Optional;

import com.techbros.springpp.model.Product;

public interface ProductDao {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product update(Product product);
    void deleteById(Long id);
}