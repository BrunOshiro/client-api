package com.jazztech.STAG2504_ClientApi.presentation.dto;

import java.time.LocalDate;

public record ClientDto (
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        AddressDto addressDto
) {
    public record AddressDto (
            Integer enderecoNumero,
            String enderecoComplemento,
            String cep
    ) {}
}