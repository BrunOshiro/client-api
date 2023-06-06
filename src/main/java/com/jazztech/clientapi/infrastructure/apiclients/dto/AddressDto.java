package com.jazztech.clientapi.infrastructure.apiclients.dto;

public record AddressDto(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        Integer ibge,
        Integer gia,
        Integer ddd,
        Integer siafi
) {
}
