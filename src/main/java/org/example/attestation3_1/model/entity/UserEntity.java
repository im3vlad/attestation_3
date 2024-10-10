package org.example.attestation3_1.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "userentity")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id  = UUID.randomUUID();

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private LocalDate birthDate;

    @Column(nullable = true)
    private String numberPhone;

    @Column(nullable = true)
    private String orderNumber;
}
