package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import lombok.Builder;

public record Address (
        String cep,
        Integer enderecoNumero,
        String enderecoComplemento,
        String enderecoRua,
        String enderecoBairro,
        String enderecoCidade,
        String enderecoUf
) {
    @Builder
    public Address {
    }
}