package com.example.inventorymanagement.service;

import com.example.inventorymanagement.entity.InventoryEntity;
import com.example.inventorymanagement.entity.ProductEntity;
import com.example.inventorymanagement.exception.ResourceNotFoundException;
import com.example.inventorymanagement.repository.InventoryRepository;
import com.example.inventorymanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // Add stock to a product
    public InventoryEntity addStock(Long productId, int quantity) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId));

        InventoryEntity inventory = inventoryRepository.findByProductId(productId)
                .orElse(new InventoryEntity());

        if (inventory.getProduct() == null) {
            inventory.setProduct(product);
        }

        inventory.setStockLevel(inventory.getStockLevel() + quantity);
        return inventoryRepository.save(inventory);
    }

    // Deduct stock from a product
    public InventoryEntity deductStock(Long productId, int quantity) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId));

        InventoryEntity inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory record not found for product ID: " + productId));

        if (inventory.getStockLevel() < quantity) {
            throw new IllegalArgumentException("Not enough stock to deduct");
        }

        inventory.setStockLevel(inventory.getStockLevel() - quantity);
        return inventoryRepository.save(inventory);
    }

    // Get current stock level for a product
    public int checkStockLevel(Long productId) {
        InventoryEntity inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory record not found for product ID: " + productId));

        return inventory.getStockLevel();
    }

    // Method to generate a report of low-stock products
    public List<InventoryEntity> getLowStockProducts(int threshold) {
        return inventoryRepository.findByStockLevelLessThan(threshold);
    }
}
