package com.giftflow.api.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
