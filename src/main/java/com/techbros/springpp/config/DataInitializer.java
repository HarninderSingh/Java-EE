package com.techbros.springpp.config;

import com.techbros.springpp.model.Product;
import com.techbros.springpp.model.User;
import com.techbros.springpp.repository.ProductRepository;
import com.techbros.springpp.repository.UserRepository;
import com.techbros.springpp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    
    @Override
    public void run(String... args) throws Exception {
        // Initialize default users if they don't exist
        if (userRepository.count() == 0) {
            createDefaultUsers();
        }
        
        // Initialize default products if they don't exist
        if (productRepository.count() == 0) {
            createDefaultProducts();
        }
    }
    
    private void createDefaultUsers() {
        // Create admin user
        User admin = new User();
        admin.setUsername("admin");
        admin.setEmail("admin@example.com");
        admin.setPassword(passwordEncoder.encode("admin123"));
        Set<String> adminRoles = new HashSet<>();
        adminRoles.add("ADMIN");
        adminRoles.add("USER");
        admin.setRoles(adminRoles);
        userRepository.save(admin);
        
        // Create regular user
        User user = new User();
        user.setUsername("user");
        user.setEmail("user@example.com");
        user.setPassword(passwordEncoder.encode("user123"));
        Set<String> userRoles = new HashSet<>();
        userRoles.add("USER");
        user.setRoles(userRoles);
        userRepository.save(user);
        
        System.out.println("Default users created:");
        System.out.println("Admin - Username: admin, Password: admin123");
        System.out.println("User - Username: user, Password: user123");
    }
    
    private void createDefaultProducts() {
        Product product1 = new Product();
        product1.setProductName("Laptop");
        product1.setProductPrice(999.99);
        product1.setProductDescription("High-performance laptop for work and gaming");
        product1.setProductQuantity(10);
        productRepository.save(product1);
        
        Product product2 = new Product();
        product2.setProductName("Smartphone");
        product2.setProductPrice(699.99);
        product2.setProductDescription("Latest smartphone with advanced features");
        product2.setProductQuantity(15);
        productRepository.save(product2);
        
        Product product3 = new Product();
        product3.setProductName("Headphones");
        product3.setProductPrice(199.99);
        product3.setProductDescription("Wireless noise-canceling headphones");
        product3.setProductQuantity(25);
        productRepository.save(product3);
        
        System.out.println("Default products created successfully");
    }
} 