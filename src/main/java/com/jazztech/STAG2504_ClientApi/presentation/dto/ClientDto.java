package com.jazztech.STAG2504_ClientApi.presentation.dto;

import java.time.LocalDate;
import java.util.UUID;

//Dados que serão enviados/recebidos para/pelo usuário
public record ClientDto (
        UUID id,
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