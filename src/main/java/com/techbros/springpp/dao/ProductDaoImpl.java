package com.techbros.springpp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techbros.springpp.model.Product;
import com.techbros.springpp.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}