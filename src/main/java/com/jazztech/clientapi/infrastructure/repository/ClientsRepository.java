package com.jazztech.clientapi.infrastructure.repository;

import com.jazztech.clientapi.infrastructure.repository.entity.ClientEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<ClientEntity, UUID> {
    List<ClientEntity> findByCpf(String cpf);
}
