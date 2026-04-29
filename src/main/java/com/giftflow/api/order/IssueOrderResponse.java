package com.giftflow.api.order;

import java.time.LocalDateTime;

public record IssueOrderResponse(
    Long id,
    Long partnerId,
    Long productId,
    Long pinInventoryId,
    String partnerOrderId,
    IssueOrderStatus status,
    LocalDateTime issuedAt,
    LocalDateTime canceledAt
) {

}
