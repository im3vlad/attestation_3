package org.example.attestation3_1.service;

import org.example.attestation3_1.repository.OrderRepository;
import org.example.attestation3_1.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.example.attestation3_1.mapper.OrderMapper;
import org.example.attestation3_1.mapper.UserMapper;
import org.example.attestation3_1.model.dto.UserDto;
import org.example.attestation3_1.model.dto.OrderDto;
import org.example.attestation3_1.model.entity.UserEntity;
import org.example.attestation3_1.model.entity.OrderEntity;
import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@SpringBootTest
class OrderServiceImplTestTest {
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private OrderService orderService;


    @MockBean
    private OrderMapper orderMapper;

    @MockBean
    private UserMapper userMapper;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @Test
   void testDeleteOrder() {
       OrderDto orderDto = new OrderDto();;
        orderService.deleteOrder(orderDto.getId());
        Mockito.verify(orderRepository, Mockito.times(1))
                .deleteById(orderDto.getId());
    }

    @Test
    void createOrderTest(){
        UserDto userDto = new UserDto();
        userDto.setUsername("username");
        userDto.setPassword("password");
        userDto.setId(UUID.randomUUID());
        userDto.setLogin("12324");
        userDto.setNumberPhone("1233432");

        OrderDto orderDto = new OrderDto();
        orderDto.setId(UUID.randomUUID());
        orderDto.setUserId(userDto.getId());
        orderDto.setOrderNumber("1");
        orderDto.setTotalPrice(new BigDecimal(10));
        OrderMapper orderMapper = new OrderMapper();
        UserMapper userMapper = new UserMapper();
        OrderEntity orderEntity = orderMapper.mapFromOrderDto(orderDto);
        UserEntity userEntity = userMapper.mapFromUserDto(userDto);
        orderRepository.save(orderEntity);
        userRepository.save(userEntity);
    }


    @Test
    void orderUpdateTest2(){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(UUID.randomUUID());
        orderDto.setUserId(UUID.randomUUID());
        orderDto.setOrderNumber("1");
        orderDto.setTotalPrice(new BigDecimal(12));
        orderRepository.findById(orderDto.getId());
        OrderMapper orderMapper = new OrderMapper();
        OrderEntity orderEntity = orderMapper.mapFromOrderDto(orderDto);
        orderRepository.save(orderEntity);
        orderMapper.mapFromOrderEntity(orderEntity);
    }

    @Test
    void getOrderTest(){
        OrderDto orderDto = new OrderDto();
        orderRepository.findById(orderDto.getId());
    }

}