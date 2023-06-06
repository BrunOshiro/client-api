package com.jazztech.clientapi.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import java.util.UUID;

//Dados que serão enviados/recebidos para/pelo usuário
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClientDto(
        UUID id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        Address address
) {
    public record Address(
            Integer enderecoNumero,
            String enderecoComplemento,
            String cep
    ) {
    }
}
