package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findByProductId(Long productId);
    List<InventoryEntity> findByStockLevelLessThan(int threshold);
}
