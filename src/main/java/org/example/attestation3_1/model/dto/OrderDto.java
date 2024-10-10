package org.example.attestation3_1.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID orderId = UUID.randomUUID();
    private UUID userId;
    private String orderNumber;
    private BigDecimal totalPrice;


}