package com.giftflow.api.inventory;

import com.giftflow.api.common.ApiResponse;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/admin-api/v1/inventories")
    public ApiResponse<CreatePinInventoryResponse> createInventories(
        @Valid @RequestBody CreatePinInventoryRequest request
    ) {
        LocalDateTime now = LocalDateTime.now();
        List<PinInventoryEntity> inventories = request.getPinCodes().stream()
            .map(pinCode -> {
                PinInventoryEntity entity = new PinInventoryEntity();
                entity.setProductId(request.getProductId());
                entity.setPinCode(pinCode);
                entity.setStatus(PinInventoryStatus.AVAILABLE);
                entity.setCreatedAt(now);
                entity.setUpdatedAt(now);
                return entity;
            }).toList();

        inventoryRepository.saveAll(inventories);

        CreatePinInventoryResponse response = new CreatePinInventoryResponse(
            request.getProductId(),
            inventories.size()
        );

        return ApiResponse.success(response, UUID.randomUUID().toString());
    }

}
