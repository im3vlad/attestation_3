package org.example.attestation3_1.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id = UUID.randomUUID();
    private   String username;
    private   String login;
    private   String password;
    private String numberPhone;
    private String orderNumber;

}
