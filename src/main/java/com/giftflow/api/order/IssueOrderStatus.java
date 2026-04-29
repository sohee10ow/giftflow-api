package com.giftflow.api.order;

//주문 발급 상태 enum class
public enum IssueOrderStatus {
    CREATED,
    RESERVED,
    ISSUED,
    CANCELED,
    FAILED
}
