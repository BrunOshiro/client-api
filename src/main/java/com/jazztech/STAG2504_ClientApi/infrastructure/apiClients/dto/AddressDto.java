package com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto;

public record AddressDto (
        String cep,
        Integer enderecoNumero,
        String enderecoComplemento,
        String enderecoRua,
        String enderecoBairro,
        String enderecoCidade,
        String enderecoUf
) {

}