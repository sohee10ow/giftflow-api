package com.giftflow.api.partner;

import com.giftflow.api.inventory.PinInventoryStatus;

public class PartnerResponse {

    private Long partnerId;
    private String name;
    private String status;
    private String callbackUrl;

    public PartnerResponse(Long partnerId, String name, String status, String callbackUrl) {
        this.partnerId = partnerId;
        this.name = name;
        this.status = status;
        this.callbackUrl = callbackUrl;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

}

