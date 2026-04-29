package com.giftflow.api.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "issue_order")
public class IssueOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "partner_id")
    private Long partnerId;

    @NotNull
    @Column(name = "product_id")
    private Long productId;


    @Column(name = "pin_inventory_id")
    private Long pinInventoryId;

    @NotNull
    @Column(name = "partner_order_id")
    private String partnerOrderId;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "status")
    private IssueOrderStatus status;


    @Column(name = "issued_at")
    private LocalDateTime issuedAt;


    @Column(name = "canceled_at")
    private LocalDateTime canceledAt;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
