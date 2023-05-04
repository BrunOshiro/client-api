package com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto;

public record AddressDto (
        // Variáveis com atributos conforme api do correio
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
    ) {}