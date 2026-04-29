package com.giftflow.api.inventory;

public record InventoryCountResponse(    Long productId,
                                         long availableCount) {

}
