package org.example.attestation3_1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.attestation3_1.mapper.OrderMapper;
import org.example.attestation3_1.mapper.UserMapper;
import org.example.attestation3_1.model.dto.OrderDto;
import org.example.attestation3_1.model.dto.UserDto;
import org.example.attestation3_1.model.entity.OrderEntity;
import org.example.attestation3_1.model.entity.UserEntity;
import org.example.attestation3_1.repository.OrderRepository;
import org.example.attestation3_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Autowired
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public void createOrder(UserDto user, OrderDto order) {
        log.info("Создание заказа");
        OrderMapper orderMapper = new OrderMapper();
        UserMapper userMapper = new UserMapper();
        OrderEntity orderEntity = orderMapper.mapFromOrderDto(order);
        UserEntity userEntity = userMapper.mapFromUserDto(user);
        orderRepository.save(orderEntity);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteOrder(UUID orderId) {
        log.info("Удаляем заказ с указанным" + orderId + ".");
        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderDto updateOrder(OrderDto order) {
        orderRepository.findById(order.getOrderId());
        OrderMapper orderMapper = new OrderMapper();
        OrderEntity orderEntity = orderMapper.mapFromOrderDto(order);
        orderRepository.save(orderEntity);
        return orderMapper.mapFromOrderEntity(orderEntity);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        log.info("Получить список всез заказов");
        return (List<OrderEntity>) orderRepository.findAll();
    }

    @Override
    public OrderEntity getOrder(UUID orderId) {
       return orderRepository.findById(orderId);

    }
}
