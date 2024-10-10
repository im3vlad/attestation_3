package org.example.attestation3_1.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.attestation3_1.model.dto.UserDto;
import org.example.attestation3_1.model.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Data
public class UserMapper {
    public UserEntity mapFromUserDto(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto.getId(),userDto.getUsername(), userDto.getLogin(),userDto.getPassword(),
                userDto.getBirthDate(),userDto.getNumberPhone(), userDto.getOrderNumber());
        userEntity.setId(UUID.randomUUID());
        userEntity.setLogin(userEntity.getLogin());
        userEntity.setUsername(userEntity.getUsername());
        userEntity.setPassword(userEntity.getPassword());
        userEntity.setNumberPhone(userEntity.getNumberPhone());
        userEntity.setBirthDate(userEntity.getBirthDate());
        userEntity.setOrderNumber(userEntity.getOrderNumber());
        return userEntity;
    }

    public UserDto mapToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setLogin(userEntity.getLogin());
        userDto.setPassword(userEntity.getPassword());
        userDto.setUsername(userEntity.getUsername());
        userDto.setNumberPhone(userDto.getNumberPhone());
        userEntity.setBirthDate(userEntity.getBirthDate());
        userDto.setOrderNumber(userEntity.getOrderNumber());
        return userDto;
    }
}
