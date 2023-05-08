package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ClientsRepository extends JpaRepository <ClientEntity, UUID>{
    List<ClientEntity> findByCpf(String cpf);
}