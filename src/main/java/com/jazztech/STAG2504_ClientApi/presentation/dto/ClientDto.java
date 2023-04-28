package com.jazztech.STAG2504_ClientApi.presentation.dto;

import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import java.time.LocalDate;

public record ClientDto (
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        AddressDto addressDto

) {}