package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository <Client, Long>{
    List<Client> findByCpf(String cpf);

}