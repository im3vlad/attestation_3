package org.example.attestation3_1.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.attestation3_1.model.dto.OrderDto;
import org.example.attestation3_1.model.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Data
public class OrderMapper {
        public OrderEntity mapFromOrderDto(OrderDto orderDto) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderId(UUID.randomUUID());
            orderEntity.setOrderNumber(orderDto.getOrderNumber());
            orderEntity.setTotalPrice(orderDto.getTotalPrice());
            return orderEntity;
        }
       public OrderDto mapFromOrderEntity(OrderEntity orderEntity) {
            OrderDto orderDto = new OrderDto();
            orderDto.setUserId(UUID.randomUUID());
            orderDto.setOrderNumber(orderEntity.getOrderNumber());
            orderDto.setTotalPrice(orderEntity.getTotalPrice());
            return orderDto;
       }
}
