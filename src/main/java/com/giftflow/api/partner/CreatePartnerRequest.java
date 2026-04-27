package com.giftflow.api.partner;

import jakarta.validation.constraints.NotBlank;

public class CreatePartnerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String callbackUrl;

    public CreatePartnerRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
