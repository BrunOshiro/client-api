package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import lombok.Builder;
import java.time.LocalDate;

//tentar mudar para record
//tirar as annotations e colocar na entidade (repositorio)
//java puro "mais agnóstico possível"
public record DomainClient(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        Address address
) {
    @Builder
    public DomainClient {
    }
}