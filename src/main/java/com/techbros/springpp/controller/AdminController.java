package com.techbros.springpp.controller;

import com.techbros.springpp.model.User;
import com.techbros.springpp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, String>> adminDashboard() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Admin Dashboard");
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdminUser(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String email = request.get("email");
            String password = request.get("password");
            
            User adminUser = userService.createAdminUser(username, email, password);
            return ResponseEntity.ok("Admin user created successfully: " + adminUser.getUsername());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("This endpoint would return all users (admin only)");
    }
    
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.ok("This endpoint would delete user with ID: " + userId + " (admin only)");
    }
} 