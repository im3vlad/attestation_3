package org.example.attestation3_1.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.attestation3_1.model.entity.UserEntity;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    void deleteById(UUID Id);
    UserEntity findById(UUID Id);
}
