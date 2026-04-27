package com.giftflow.api.partner;

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
public class PartnerController {

    private final PartnerRepository partnerRepository;

    public PartnerController(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @PostMapping("/admin-api/v1/partners")
    public ApiResponse<PartnerResponse> createPartner(@Valid @RequestBody CreatePartnerRequest request) {
        PartnerEntity partner = new PartnerEntity();
        partner.setName(request.getName());
        partner.setStatus("ACTIVE");
        partner.setCallbackUrl(request.getCallbackUrl());

        LocalDateTime now = LocalDateTime.now();
        partner.setCreatedAt(now);
        partner.setUpdatedAt(now);

        PartnerEntity savePartner = partnerRepository.save(partner);

        PartnerResponse response = new PartnerResponse(
            savePartner.getId(),
            savePartner.getName(),
            savePartner.getStatus(),
            savePartner.getCallbackUrl()
        );
        return ApiResponse.success(response, UUID.randomUUID().toString());
    }


    @GetMapping("/admin-api/v1/partners/{id}")
    public ApiResponse<PartnerResponse> getPartner(@PathVariable long id) {
        PartnerEntity partner = partnerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("없는데이터입니다."));

        PartnerResponse response = new PartnerResponse(
            partner.getId(),
            partner.getName(),
            partner.getStatus(),
            partner.getCallbackUrl()
        );

        return ApiResponse.success(response, UUID.randomUUID().toString());
    }

    @GetMapping("/admin-api/v1/partners/all")
    public ApiResponse<List<PartnerResponse>> getPartners() {
        List<PartnerEntity> partners = partnerRepository.findAll();
        List<PartnerResponse> data = partners.stream().map(
            value -> new PartnerResponse(
                value.getId(),
                value.getName(),
                value.getStatus(),
                value.getCallbackUrl()
            )
        ).toList();
        return ApiResponse.success(data, UUID.randomUUID().toString());
    }

}
