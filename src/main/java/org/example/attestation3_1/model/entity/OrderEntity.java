package org.example.attestation3_1.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "orderentity")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userid;

    @Column(nullable = false)
    private String orderNumber;

    @Column(nullable = false)
    private BigDecimal totalPrice;
}