package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import lombok.Builder;
import java.time.LocalDate;

public record DomainClient(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        Address address
) {
    public record Address(
            Integer enderecoNumero,
            String enderecoComplemento,
            String cep
            ) {}
    @Builder
    public DomainClient {
    }
}