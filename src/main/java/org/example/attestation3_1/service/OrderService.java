package org.example.attestation3_1.service;

import org.example.attestation3_1.model.dto.OrderDto;
import org.example.attestation3_1.model.dto.UserDto;
import org.example.attestation3_1.model.entity.OrderEntity;

import java.util.UUID;

public interface OrderService {
    void createOrder(UserDto user, OrderDto order);
    void deleteOrder(UUID orderId);
    OrderDto updateOrder(OrderDto order);
    Iterable<OrderEntity> getAllOrders();
    OrderEntity getOrder(UUID orderId);
}

