package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import com.jazztech.STAG2504_ClientApi.infrastructure.util.ValidationCustom;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

public record Address (
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP inválido, deve estar no formato 00000-000")
        String cep,
        Integer enderecoNumero,
        String enderecoComplemento,
        String enderecoRua,
        String enderecoBairro,
        String enderecoCidade,
        String enderecoUf
) {
    @Builder
    public Address(
            String cep,
            Integer enderecoNumero,
            String enderecoComplemento,
            String enderecoRua,
            String enderecoBairro,
            String enderecoCidade,
            String enderecoUf
    ) {
        this.cep = cep;
        this.enderecoNumero = enderecoNumero;
        this.enderecoComplemento = enderecoComplemento;
        this.enderecoRua = enderecoRua;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCidade = enderecoCidade;
        this.enderecoUf = enderecoUf;
        ValidationCustom.validator(this);
    }
}