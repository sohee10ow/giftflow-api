package com.giftflow.api.inventory;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class CreatePinInventoryRequest {

    @NotNull
    private Long productId;

    @NotEmpty
    private List<String> pinCodes;

    public Long getProductId() {
        return productId;
    }

    public List<String> getPinCodes() {
        return pinCodes;
    }
}
