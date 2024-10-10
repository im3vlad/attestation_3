package org.example.attestation3_1.controller;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.attestation3_1.model.dto.OrderDto;
import org.example.attestation3_1.model.dto.UserDto;
import org.example.attestation3_1.model.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.attestation3_1.service.OrderService;

import java.util.UUID;
@Controller
@RequestMapping("/pizzeria")
@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;



    @PostMapping("/create")
    @Operation(
            description = "Создание нового заказа"
    )
    public void createOrder(OrderDto orderDto, UserDto userDto) {
        log.info("Отправлен запрос на создание заказа с номером" + userDto.getOrderNumber()+ "имя заказчика" + userDto.getUsername());

        orderService.createOrder(userDto, orderDto);
    }


    @GetMapping("/status")
    @Operation(

    )
    public OrderEntity statusOrder(UUID orderId){
        log.info("Отправлен запрос на получение статуса заказа с Id" + orderId );
        return orderService.getOrder(orderId);
    }

    @DeleteMapping("/delete")
    //аннотация для возвращения статуса выполнения работы контроллера
    public void deleteOrder(UUID orderId){
        orderService.deleteOrder(orderId);
    }

    @PutMapping("/update")
    public OrderDto updateOrder(OrderDto order){
        return orderService.updateOrder(order);
    }

    @GetMapping("/orders")
    public Iterable<OrderEntity> getOrders(){
        return orderService.getAllOrders();
    }



}
