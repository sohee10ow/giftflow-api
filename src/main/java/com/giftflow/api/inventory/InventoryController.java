package com.giftflow.api.inventory;

import com.giftflow.api.common.ApiResponse;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    private final PinInventoryRepository inventoryRepository;


    public InventoryController(PinInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/admin-api/v1/products/{productId}/inventory")
    public ApiResponse<InventoryCountResponse> getInventory(@PathVariable Long productId) {
        long count = inventoryRepository.countByProductIdAndStatus(
            productId,
            PinInventoryStatus.AVAILABLE
        );

        InventoryCountResponse response = new InventoryCountResponse(productId, count);
        return ApiResponse.success(response, UUID.randomUUID().toString());
    }

}
