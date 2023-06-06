package com.jazztech.clientapi.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClientDtoResponse(
        UUID id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        AddressDtoResponse addressDtoResponse,
        LocalDateTime creationDate,
        LocalDateTime updateDate
) {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record AddressDtoResponse(
            UUID id,
            String cep,
            Integer enderecoNumero,
            String enderecoComplemento,
            String enderecoRua,
            String enderecoBairro,
            String enderecoCidade,
            String enderecoUf,
            LocalDateTime creationDate,
            LocalDateTime updateDate
    ) {
    }
}
