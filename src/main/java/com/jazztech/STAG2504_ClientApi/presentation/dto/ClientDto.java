package com.jazztech.STAG2504_ClientApi.presentation.dto;

import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record ClientDto (
        Long id,
        @NotBlank
        String nome,
        @CPF
        String cpf,
        @NotNull
        @Past
        LocalDate dataNascimento,
        AddressDto addressDto

) {}