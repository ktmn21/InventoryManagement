package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.InventoryEntity;
import com.example.inventorymanagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Add stock to a product
    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addStock(@PathVariable Long productId, @RequestParam int quantity) {
        inventoryService.addStock(productId, quantity);
        return ResponseEntity.ok("Added successfully");
    }

    // Deduct stock from a product
    @PostMapping("/deduct/{productId}")
    public ResponseEntity<String> deductStock(@PathVariable Long productId, @RequestParam int quantity) {
        inventoryService.deductStock(productId, quantity);
        return ResponseEntity.ok("Deducted successfully");
    }

    // Get the current stock level of a product
    @GetMapping("/stock/{productId}")
    public ResponseEntity<Integer> checkStockLevel(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.checkStockLevel(productId));
    }

}
