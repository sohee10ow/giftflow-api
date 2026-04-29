package com.giftflow.api.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PinInventoryRepository extends JpaRepository<PinInventoryEntity, Long> {

    long countByProductIdAndStatus(Long productId, PinInventoryStatus status);
}
