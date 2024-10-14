package org.example.attestation3_1.controller;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.attestation3_1.model.dto.OrderDto;
import org.example.attestation3_1.model.dto.UserDto;
import org.example.attestation3_1.model.entity.OrderEntity;
import org.springframework.web.bind.annotation.*;
import org.example.attestation3_1.service.OrderService;

import java.util.UUID;
@RequestMapping("/api/v1/pizzeria")
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;



    @PostMapping
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
    public OrderEntity statusOrder(UUID Id){
        log.info("Отправлен запрос на получение статуса заказа с Id" + Id );
        return orderService.getOrder(Id);
    }

    @DeleteMapping
    @Operation(

    )
    //аннотация для возвращения статуса выполнения работы контроллера
    public void deleteOrder(UUID Id){
        orderService.deleteOrder(Id);
    }

    @PutMapping
    @Operation(

    )
    public OrderDto updateOrder(OrderDto order){
        return orderService.updateOrder(order);
    }

    @GetMapping("/orders")
    @Operation(

    )
    public Iterable<OrderEntity> getOrders(){
        return orderService.getAllOrders();
    }



}
