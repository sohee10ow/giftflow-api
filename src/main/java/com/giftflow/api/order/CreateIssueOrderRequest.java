package com.giftflow.api.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateIssueOrderRequest {
    @NotNull
    private Long partnerId;

    @NotNull
    private Long productId;

    @NotBlank
    private String partnerOrderId;

    public Long getPartnerId() {
        return partnerId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getPartnerOrderId() {
        return partnerOrderId;
    }
}
