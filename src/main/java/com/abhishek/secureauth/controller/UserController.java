package com.abhishek.secureauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getUserProfile(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        response.put("email", authentication.getName());
        response.put("authorities", authentication.getAuthorities());
        response.put("message", "This is a protected user route");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, String>> getDashboard() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to User Dashboard");
        response.put("access", "USER or ADMIN can access this");
        return ResponseEntity.ok(response);
    }
}