package org.example.attestation3_1.repository;

import org.example.attestation3_1.model.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

    void deleteById(UUID Id);
    OrderEntity findById(UUID Id);
}
